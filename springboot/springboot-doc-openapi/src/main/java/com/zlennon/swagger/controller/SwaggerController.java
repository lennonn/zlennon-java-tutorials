package com.zlennon.swagger.controller;


import com.zlennon.swagger.Persion;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试docOpenApi接口")
public class SwaggerController {

    @Operation(summary = "Get a person by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Persion",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Persion.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Persion not found",
                    content = @Content) })
    @GetMapping("testSwagger")
    public ResponseEntity<Object> docOpenApi(String name){
        Persion p =new Persion();
        p.setName(name);
      return new ResponseEntity<>(p,HttpStatusCode.valueOf(200));
    }
}
