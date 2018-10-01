package com.ggstudy.trans.controller;

import com.ggstudy.trans.domain.Trans;
import com.ggstudy.trans.model.ResponseModel;
import com.ggstudy.trans.service.proxy.ITransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransController {

    private ITransService transService;

    @Autowired
    public TransController(ITransService transService) {
        this.transService = transService;
    }

    @RequestMapping("insert")
    public ResponseModel insertTrans(@RequestBody Trans trans) {
        if (transService.insertTrans(trans)) {
            return ResponseModel.succecc();
        }
        return ResponseModel.fail();
    }

}
