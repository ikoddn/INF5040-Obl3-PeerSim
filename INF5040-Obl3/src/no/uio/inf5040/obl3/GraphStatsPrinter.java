package no.uio.inf5040.obl3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import peersim.config.Configuration;
import peersim.core.CommonState;
import peersim.reports.GraphObserver;

public abstract class GraphStatsPrinter extends GraphObserver {

	private static final String PAR_OUTFILE = "outf";
	private static final String PAR_STEP = "step";

	protected final int step;
	private PrintWriter writer;

	protected GraphStatsPrinter(String name) throws FileNotFoundException {
		super(name);

		step = Configuration.getInt(name + "." + PAR_STEP, 0);

		String outfile = Configuration.getString(name + "." + PAR_OUTFILE);
		try {
			writer = new PrintWriter(outfile, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// Not possible
		}
	}

	@Override
	public final boolean execute() {
		boolean result = execute(writer);

		// Check if this is the last cycle
		if (CommonState.getTime() + step >= CommonState.getEndTime()) {
			writer.close();
		}

		return result;
	}

	protected abstract boolean execute(PrintWriter writer);
}
