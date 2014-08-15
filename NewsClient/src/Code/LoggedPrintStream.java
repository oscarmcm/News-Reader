/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Code;

import java.io.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.*;
import java.lang.reflect.Field;

/**
 *
 * @author oscar
 */
public class LoggedPrintStream extends PrintStream {

    final StringBuilder buf;
    final PrintStream underlying;

    LoggedPrintStream(StringBuilder sb, OutputStream os, PrintStream ul) {
        super(os);
        this.buf = sb;
        this.underlying = ul;
    }

    public static LoggedPrintStream create(PrintStream toLog) {
        try {
            final StringBuilder sb = new StringBuilder();
            Field f = FilterOutputStream.class.getDeclaredField("out");
            f.setAccessible(true);
            OutputStream psout = (OutputStream) f.get(toLog);
            return new LoggedPrintStream(sb, new FilterOutputStream(psout) {
                public void write(int b) throws IOException {
                    super.write(b);
                    sb.append((char) b);
                }
            }, toLog);
        } catch (NoSuchFieldException shouldNotHappen) {
        } catch (IllegalArgumentException shouldNotHappen) {
        } catch (IllegalAccessException shouldNotHappen) {
        }
        return null;
    }
}
