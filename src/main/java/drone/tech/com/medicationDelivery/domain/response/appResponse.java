package drone.tech.com.medicationDelivery.domain.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class appResponse {

	private int statusCode;
	private HttpStatus httpStatus;
	private String message;
	private Object data;

}
