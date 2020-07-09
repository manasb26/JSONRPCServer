package com.picavi.jsonrpc.rpc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.picavi.jsonrpc.model.Pickline;
import com.picavi.jsonrpc.model.Picklist;
import com.picavi.jsonrpc.model.Request;
import com.picavi.jsonrpc.model.Response;
import com.picavi.jsonrpc.model.SuccessResponse;

@Service
public class OrderPicking {

	public Response getPickList(Request request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode pickRequest = request.getParams();
		Picklist pickList = mapper.treeToValue(pickRequest, Picklist.class);

		List<Pickline> pickLines = new ArrayList<Pickline>();
		pickLines.add(new Pickline("1", "01-05-34-04", 120.0, "Guinness", "gallon"));
		pickLines.add(new Pickline("2", "01-12-11-03", 80.0, "Murphy's Irish Red", "gallon"));
		pickList.setLines(pickLines);

        return new SuccessResponse(request.getId(), pickList);
	}
}
