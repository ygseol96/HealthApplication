package com.ygseol.helath.healthapplication;


import com.ygseol.helath.healthapplication.model.dInfo;
import com.ygseol.helath.healthapplication.service.dInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ygseol.helath.healthapplication.model.ResultData;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(method = {RequestMethod.POST ,RequestMethod.GET} , value = "/yg")
public class MainController {

    private final dInfoRepository infoRepository;
    private final ObjectMapper objectMapper;

    @GetMapping("/getDrugInfo")
    public ResultData<String> getDrugInfo(HttpServletRequest req, HttpServletResponse res) throws URISyntaxException, IOException, InterruptedException {


        HttpClient client = HttpClient.newHttpClient(); //HTTP 프로토콜 요청하는 인스턴스 생성
        URI url = new URI("http://openapi.foodsafetykorea.go.kr/api/8e44d4748d1f4dcc9205/I0760/json/1/5"); //API 규격에 맞게 파라미터 전송.
        HttpRequest request = HttpRequest.newBuilder().GET().uri(url).build(); //빌더형식으로 속성값 지정.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //응답객체를 별도로 만들어. 클라이언트 객체와함께 요청객체를 적재하여 요청 및 응답
        System.out.println(response.body());
        JsonNode node = objectMapper.readTree(response.body());
        JsonNode json = node.get("I0760").get("row");
        List<dInfo> info = objectMapper.readValue(json.toString(), new TypeReference<List<dInfo>>(){});

        infoRepository.saveAll(info);
        ResultData<String> resultData = new ResultData<>();
        resultData.setSuc("SetBody() TEST!!!!!");
        return resultData;
    }



}
