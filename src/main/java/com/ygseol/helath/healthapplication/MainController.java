package com.ygseol.helath.healthapplication;


import com.ygseol.helath.healthapplication.model.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(method = {RequestMethod.POST ,RequestMethod.GET} , value = "/yg")
public class MainController {

    @GetMapping("/getDrugInfo")
    public ResultData getDrugInfo(HttpServletRequest req, HttpServletResponse res) {

        ResultData resultData = new ResultData();
        resultData.setSuc("SetBody() TEST!!!!!");
        return resultData;
    }



}
