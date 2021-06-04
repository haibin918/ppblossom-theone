package com.meicai.ppblossom.theone;

import com.meicai.ppblossom.theone.api.response.JsonResult;
//import com.meicai.ppblossom.theone.domain.appoint.service.RedisTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @ClassName SuccessController
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/4 10:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("/dmallladder/appoint")
@Slf4j
public class SuccessController {

//    @Autowired
//    private RedisTestService redisTestService;


    @RequestMapping("/check")
    public String check() {
        return "success";
    }


    @RequestMapping("/test")
    public void test() throws Exception {

    }

//    @RequestMapping("/redisTest")
//    public String redisTest() {
//
//        return redisTestService.redisTest();
//    }

    /**
     * 接收通知(测试)
     * @param request
     * @return
     */
    @RequestMapping("/notify")
    public JsonResult notify(HttpServletRequest request){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("通知接收的请求体为==========:"+sb.toString());
        return JsonResult.success();
    }


}



