package com.jcalvopinam.service;

import brave.Span;
import brave.Tracer;
import com.jcalvopinam.util.Commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeServiceImpl.class);
    private final Tracer tracer;

    @Autowired
    public ExchangeServiceImpl(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public Double dollarToEuro(Double dollar) {
        Span remoteDependency = tracer.nextSpan()
                                      .name(Commons.getArtifactName(Converter.class))
                                      .start();

        Double euro = Converter.dollarToEuro(dollar);

        remoteDependency.tag("dollarToEuro ", "dollarToEuro: " + euro);
        return this.response(dollar, euro, remoteDependency);
    }

    @Override
    public Double euroToDollar(Double euro) {
        Span remoteDependency = tracer.nextSpan()
                                      .name(Commons.getArtifactName(Converter.class))
                                      .start();
        Double dollar = Converter.euroToDollar(euro);

        remoteDependency.tag("dollarToEuro ", "dollarToEuro: " + euro);
        return this.response(euro, dollar, remoteDependency);
    }

    private Double response(Double input, Double output, Span currentSpan) {
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(currentSpan)) {
            LOGGER.info("Converting {} Dollars to Euros: {} ", input, output);
            return output;
        } catch (Exception e) {
            currentSpan.error(e);
            throw e;
        } finally {
            currentSpan.finish();
        }
    }
}
