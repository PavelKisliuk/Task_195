import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Task_195 {
	public static void main(String[] args) {
		String outputPath = "OUTPUT.TXT";
		String inputPath = "INPUT.TXT";
		SulphideCalculator test = new SulphideCalculator(inputPath);
		try (BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class SulphideCalculator {
	private int panelAmount;
	private int sizeA;
	private int sizeB;

	public SulphideCalculator(String path) {
		try (final BufferedReader input = Files.newBufferedReader(Paths.get(path))) {
			String data = input.lines().collect(Collectors.joining());
			String[] parsedData = data.split(" ");
			panelAmount = Integer.parseInt(parsedData[0]);
			sizeA = Integer.parseInt(parsedData[1]);
			sizeB = Integer.parseInt(parsedData[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int count() {
		return panelAmount * sizeA * sizeB * 2;
	}

	@Override
	public String toString() {
		return String.valueOf(count());
	}
}