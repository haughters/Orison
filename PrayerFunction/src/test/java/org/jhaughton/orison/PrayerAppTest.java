package org.jhaughton.orison;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
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
    assertTrue(content.contains("\"content\""));
    assertTrue(content.contains("\"hello world\""));
  }
}
