package me.dinowernli.grpc.polyglot.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.DynamicMessage;

import io.grpc.stub.StreamObserver;

/**
 * A {@link StreamObserver} which logs the progress of the rpc and some stats about the results
 * once the rpc has completed. Note that this does *not* log the contents of the response.
 */
public class LoggingStatsWriter implements StreamObserver<DynamicMessage> {
  private static final Logger logger = LoggerFactory.getLogger(LoggingStatsWriter.class);
  private int numResponses;
  private int numTotal;
  private int numSuccesses;
  private long start;

  public LoggingStatsWriter() {
    numResponses = 0;
    start = System.currentTimeMillis();
  }

  @Override
  public void onCompleted() {
    //logger.info("Completed rpc with " + numResponses + " response(s) in " + (System.currentTimeMillis() - start) + " ms");
    if (numTotal >= 50) {
	    logger.info("Successes " + numSuccesses);
	    numTotal = 0;
	    numSuccesses = 0;
    }
    numSuccesses++;
    numTotal++;
//    logger.info("Successes " + numSuccesses + " failures " + numTotal);
  }

  @Override
  public void onError(Throwable t) {
    //logger.error("Aborted rpc due to error in " + (System.currentTimeMillis() - start) + " ms", t);
    if (numTotal >= 50) {
	    logger.info("Successes " + numSuccesses);
	    numTotal = 0;
	    numSuccesses = 0;
    }
    numTotal++;
  }

  @Override
  public void onNext(DynamicMessage message) {
    //logger.info("Got response message");
    ++numResponses;
  }
}
