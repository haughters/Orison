package org.jhaughton.orison;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import org.jhaughton.orison.model.Prayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrayerAppTest {
  @Test
  void successfulResponse() {
    PrayerApp prayerApp = new PrayerApp();
    APIGatewayProxyResponseEvent result = prayerApp.handleRequest(null, null);
    assertEquals(200, result.getStatusCode().intValue());
    assertEquals("application/json", result.getHeaders().get("Content-Type"));
    String content = result.getBody();
    assertNotNull(content);
    Gson gson = new Gson();
    Prayer response = gson.fromJson(content, Prayer.class);
    assertNotNull(response.getId());
    assertEquals("Test Content", response.getContent());
    assertNotNull(response.getOrganisation());
    assertNotNull(response.getOrganisation().getId());
    assertEquals("Test Org", response.getOrganisation().getName());
  }
}
