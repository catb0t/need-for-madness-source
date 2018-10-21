package ibxm;

public class Instrument
{
    public String name;
    public int numSamples;
    public int vibratoType;
    public int vibratoSweep;
    public int vibratoDepth;
    public int vibratoRate;
    public int volumeFadeOut;
    public Envelope volumeEnvelope;
    public Envelope panningEnvelope;
    public int[] keyToSample;
    public Sample[] samples;
    
    public Instrument() {
        this.name = "";
        this.numSamples = 1;
        this.vibratoType = 0;
        this.vibratoSweep = 0;
        this.vibratoDepth = 0;
        this.vibratoRate = 0;
        this.volumeFadeOut = 0;
        this.volumeEnvelope = new Envelope();
        this.panningEnvelope = new Envelope();
        this.keyToSample = new int[97];
        this.samples = new Sample[] { new Sample() };
    }
    
    public void toStringBuffer(final StringBuffer out) {
        out.append("Name: " + this.name + '\n');
        if (this.numSamples > 0) {
            out.append("Num Samples: " + this.numSamples + '\n');
            out.append("Vibrato Type: " + this.vibratoType + '\n');
            out.append("Vibrato Sweep: " + this.vibratoSweep + '\n');
            out.append("Vibrato Depth: " + this.vibratoDepth + '\n');
            out.append("Vibrato Rate: " + this.vibratoRate + '\n');
            out.append("Volume Fade Out: " + this.volumeFadeOut + '\n');
            out.append("Volume Envelope:\n");
            this.volumeEnvelope.toStringBuffer(out);
            out.append("Panning Envelope:\n");
            this.panningEnvelope.toStringBuffer(out);
            for (int samIdx = 0; samIdx < this.numSamples; ++samIdx) {
                out.append("Sample " + samIdx + ":\n");
                this.samples[samIdx].toStringBuffer(out);
            }
            out.append("Key To Sample: ");
            for (int keyIdx = 1; keyIdx < 97; ++keyIdx) {
                out.append(this.keyToSample[keyIdx] + ", ");
            }
            out.append('\n');
        }
    }
}
