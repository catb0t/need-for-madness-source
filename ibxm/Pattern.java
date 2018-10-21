package ibxm;

public class Pattern
{
    public int numRows;
    public byte[] data;
    
    public Pattern(final int numChannels, final int numRows) {
        this.numRows = numRows;
        this.data = new byte[numChannels * numRows * 5];
    }
    
    public void getNote(final int index, final Note note) {
        final int offset = index * 5;
        note.key = (this.data[offset] & 0xFF);
        note.instrument = (this.data[offset + 1] & 0xFF);
        note.volume = (this.data[offset + 2] & 0xFF);
        note.effect = (this.data[offset + 3] & 0xFF);
        note.param = (this.data[offset + 4] & 0xFF);
    }
    
    public void toStringBuffer(final StringBuffer out) {
        final char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        final int channels = this.data.length / (this.numRows * 5);
        int data_offset = 0;
        for (int row = 0; row < this.numRows; ++row) {
            for (int channel = 0; channel < channels; ++channel) {
                for (int n = 0; n < 5; ++n) {
                    final int b = this.data[data_offset++];
                    if (b == 0) {
                        out.append("--");
                    }
                    else {
                        out.append(hex[b >> 4 & 0xF]);
                        out.append(hex[b & 0xF]);
                    }
                }
                out.append(' ');
            }
            out.append('\n');
        }
    }
}
