package ibxm;

public class Envelope
{
    public boolean enabled;
    public boolean sustain;
    public boolean looped;
    public int sustainTick;
    public int loopStartTick;
    public int loopEndTick;
    public int numPoints;
    public int[] pointsTick;
    public int[] pointsAmpl;
    
    public Envelope() {
        this.enabled = false;
        this.sustain = false;
        this.looped = false;
        this.sustainTick = 0;
        this.loopStartTick = 0;
        this.loopEndTick = 0;
        this.numPoints = 1;
        this.pointsTick = new int[1];
        this.pointsAmpl = new int[1];
    }
    
    public int nextTick(int tick, final boolean keyOn) {
        ++tick;
        if (this.looped && tick >= this.loopEndTick) {
            tick = this.loopStartTick;
        }
        if (this.sustain && keyOn && tick >= this.sustainTick) {
            tick = this.sustainTick;
        }
        return tick;
    }
    
    public int calculateAmpl(final int tick) {
        int ampl = this.pointsAmpl[this.numPoints - 1];
        if (tick < this.pointsTick[this.numPoints - 1]) {
            int point = 0;
            for (int idx = 1; idx < this.numPoints; ++idx) {
                if (this.pointsTick[idx] <= tick) {
                    point = idx;
                }
            }
            final int dt = this.pointsTick[point + 1] - this.pointsTick[point];
            final int da = this.pointsAmpl[point + 1] - this.pointsAmpl[point];
            ampl = this.pointsAmpl[point];
            ampl += (da << 24) / dt * (tick - this.pointsTick[point]) >> 24;
        }
        return ampl;
    }
    
    public void toStringBuffer(final StringBuffer out) {
        out.append("Enabled: " + this.enabled + '\n');
        out.append("Sustain: " + this.sustain + '\n');
        out.append("Looped: " + this.looped + '\n');
        out.append("Sustain Tick: " + this.sustainTick + '\n');
        out.append("Loop Start Tick: " + this.loopStartTick + '\n');
        out.append("Loop End Tick: " + this.loopEndTick + '\n');
        out.append("Num Points: " + this.numPoints + '\n');
        out.append("Points: ");
        for (int point = 0; point < this.numPoints; ++point) {
            out.append("(" + this.pointsTick[point] + ", " + this.pointsAmpl[point] + "), ");
        }
        out.append('\n');
    }
}
