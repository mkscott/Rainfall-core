package org.rainfall.gatling.operation;

import org.rainfall.Assertion;
import org.rainfall.Configuration;
import org.rainfall.Operation;
import org.rainfall.gatling.configuration.HttpConfig;

import java.util.List;
import java.util.Map;

/**
 * @author Aurelien Broszniowski
 */

public class HttpOperation extends Operation {
  private String description;
  private String path = null;

  public HttpOperation(final String description) {
    this.description = description;
  }

  public Operation get(final String path) {
    this.path = path;
    return this;
  }

  @Override
  public void exec(final Map<Class<? extends Configuration>, Configuration> configurations, final List<Assertion> assertions) {
    String url = null;
    HttpConfig httpConfig = (HttpConfig)configurations.get(HttpConfig.class);
    if (httpConfig != null) {
      url = httpConfig.getUrl();
    }
    if (url == null) {
      throw new RuntimeException("baseURL of org.rainfall.gatling.HttpConfig is missing");
    }

    if (path != null) {
      url += path;
    }
    System.out.println(">>> Get page for URL  = " + url + " (" + description + ")");
  }

  @Override
  public void run() {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
