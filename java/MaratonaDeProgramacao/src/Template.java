import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Template {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = in.readLine().split(" ");
        in.close();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write('s');
        out.newLine();
        out.close();
	}

}
