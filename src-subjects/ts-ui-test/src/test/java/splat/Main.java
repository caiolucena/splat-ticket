package splat;

import java.io.File;
import java.io.PrintStream;

import backtracker.Backtracker;
import sampling.Sampling;
import sampling.Sampling.Mode;
import trie.TrieST;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintStream log = new PrintStream(new File("results_gpl.txt"));
		String dataPath = (new java.io.File("./../..")).getCanonicalPath().toString() + "/data/valid/";

		/***** SPLat *****/
		Sampling.mode = Mode.SPLAT;
		args = new String[] { "--testclass", "newTests.TestAll", "--logfile", dataPath + "gpl_splat.txt", "--shouldsample",
				"false", "--samplerate", "1", "--seed", "95729", "--validate", "true" };

		SPLat spLat = new SPLat(TrainTicketVariables.getSINGLETON());
		spLat.run(args, new Backtracker(true, true, new TrieST<Boolean>()));

	}

}
