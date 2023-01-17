import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mikas
 *
 */
public class ReportFileWriter {
    private PrintWriter writer;

    /**
     * @throws IOException
     */
    public ReportFileWriter() throws IOException {
        this.writer = new PrintWriter("selvitys.txt", "UTF-8");
    }

    /**
     * @param report
     */
    public void write(String report) {
        writer.println(report);
    }

    /**
     * 
     */
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}