package ru.pcs.soap.endpoints;

import com.my.service.GetUsersRequest;
import com.my.service.GetUsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.pcs.soap.services.UsersService;

@Endpoint
@RequiredArgsConstructor
public class UsersEntryPoint {

	private final UsersService usersService;

	@PayloadRoot(namespace = "http://my.com/service", localPart = "getUsersRequest")
	@ResponsePayload
	public GetUsersResponse getUsers(@RequestPayload GetUsersRequest request) {
		GetUsersResponse response = new GetUsersResponse();
		response.getUsers().addAll(usersService.getUsersLimit(request.getLimit().intValue()));

		return response;
	}
}