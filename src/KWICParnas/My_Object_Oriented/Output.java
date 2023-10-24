package KWICParnas.My_Object_Oriented;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output {
    private ArrayList<String> kwicList;
    private BufferedWriter outputFile;

    public Output(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

/*    public void output(String filename) {
        Iterator<String> it = kwicList.iterator();
        try {
            outputFile = new BufferedWriter(new FileWriter(filename));
            while (it.hasNext()) {
                outputFile.write(it.next() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputFile != null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
    public void output(String filename, String string) {
        // 根据format参数选择输出格式
        switch (string) {
            case "TEXT":
                writeTextOutput(filename);
                break;
            case "HTML":
                writeHtmlOutput(filename);
                break;
            // 添加其他格式的输出逻辑
            // ...
        }
    }


    private void writeTextOutput(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : kwicList) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHtmlOutput(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("<html>");
            writer.newLine();
            writer.write("<body>");
            writer.newLine();
            writer.write("<ul>");
            writer.newLine();

            for (String line : kwicList) {
                writer.write("<li>" + line + "</li>");
                writer.newLine();
            }

            writer.write("</ul>");
            writer.newLine();
            writer.write("</body>");
            writer.newLine();
            writer.write("</html>");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum OutputFormat {
        TEXT,
        HTML
    }
}
