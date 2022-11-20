package es.rest;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.time.Duration;

public class _01_MainClienteSBMensaje {

	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
			.connectTimeout(Duration.ofSeconds(10)).build();

	public static void main(String[] args) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8080/mensaje"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot")
				.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// print response headers
		HttpHeaders headers = response.headers();
		headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

		// print status code
		System.out.println(response.statusCode());

		// print response body
		System.out.println(response.body());

	}

}
