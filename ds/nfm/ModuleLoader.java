package ds.nfm;

import ds.nfm.xm.IBXModSlayer;
import ds.nfm.mod.ModSlayer;
import java.util.zip.ZipEntry;
import ds.nfm.mod.Mod;
import ds.nfm.xm.IBXMod;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.URL;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import java.io.FileInputStream;
import java.io.File;

public class ModuleLoader
{
    public static Module loadMod(final String s) throws FileNotFoundException, IOException {
        return loadMod(new ZipInputStream(new FileInputStream(new File(s))));
    }
    
    public static Module loadMod(final URL url) throws IOException {
        return loadMod(new ZipInputStream(new DataInputStream(url.openStream())));
    }
    
    public static Module loadMod(final byte[] array) throws IOException {
        return loadMod(new ZipInputStream(new ByteArrayInputStream(array)));
    }
    
    public static Module loadMod(final ZipInputStream zipInputStream) throws IOException {
        final ZipEntry nextEntry = zipInputStream.getNextEntry();
        final String name = nextEntry.getName();
        int i = (int)nextEntry.getSize();
        byte[] byteArray;
        if (i == -1) {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int read;
            while ((read = zipInputStream.read()) != -1) {
                byteArrayOutputStream.write(read);
            }
            byteArray = byteArrayOutputStream.toByteArray();
        }
        else {
            byteArray = new byte[i];
            int n = 0;
            while (i > 0) {
                final int read2 = zipInputStream.read(byteArray, n, i);
                n += read2;
                i -= read2;
            }
        }
        zipInputStream.close();
        Module module;
        if (name.toLowerCase().endsWith(".xm") || name.toLowerCase().endsWith(".s3m")) {
            module = new IBXMod(byteArray);
        }
        else {
            module = new Mod(byteArray);
        }
        return module;
    }
    
    public static ModuleSlayer prepareSlayer(final Module module, final int n, final int n2, final int n3) {
        if (module instanceof Mod) {
            return new ModSlayer((Mod)module, n, n2, n3);
        }
        if (module instanceof IBXMod) {
            return new IBXModSlayer((IBXMod)module, n, n2, n3);
        }
        throw new ModuleException("Unsuported module format: " + module.getName());
    }
}
