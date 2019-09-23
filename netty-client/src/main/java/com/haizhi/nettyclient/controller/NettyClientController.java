package com.haizhi.nettyclient.controller;

import com.haizhi.nettyclient.domian.qo.NettyQo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;

@RestController
@Api(description = "[Arango图搜索-通用图查询]-K层展开/最短路径/全路径")
@RequestMapping("/client")
public class NettyClientController {

    @ApiOperation(value = "Post请求")
    @PostMapping(value = "/expand")
    public Response<String> expand(@ApiParam(value = "查询条件", required = true) @RequestBody @Valid NettyQo nettyQo) {
        return null;
    }

    @ApiOperation(value = "GET请求")
    @GetMapping("/generateData")
    public Response dynamicBuildData() {
        return null;
    }
}
