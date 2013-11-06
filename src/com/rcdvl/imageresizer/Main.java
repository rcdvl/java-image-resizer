package com.rcdvl.imageresizer;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException, NumberFormatException, IOException {
		Options commandLineOptions = new Options();
		commandLineOptions.addOption("r", false, "recursive locate image files");
		commandLineOptions.addOption("s", "scale", true, "scale ratio");
		
		CommandLineParser parser = new GnuParser();
		CommandLine cmd = parser.parse(commandLineOptions, args);
		
		if(cmd.hasOption("r")) {
			ImageResizer.resizeRecursively(cmd.getArgs()[0], Double.parseDouble(cmd.getOptionValue('s')));
		}
		else {
		    // print the date
		}

	}

}
