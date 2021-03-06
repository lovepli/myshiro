package com.coderman.rbac.job.controller;

import com.coderman.rbac.job.bean.SickPaper;
import com.coderman.rbac.job.service.SickPaperService;
import com.coderman.rbac.job.vo.SickPaperVo;
import com.coderman.rbac.sys.bean.User;
import com.coderman.rbac.sys.contast.MyConstant;
import com.coderman.rbac.sys.enums.ResultEnum;
import com.coderman.rbac.sys.utils.WebUtil;
import com.coderman.rbac.sys.vo.PageVo;
import com.coderman.rbac.sys.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangyukang on 2019/11/27 17:31
 */
@RestController
@RequestMapping("/sickPaper")
public class SickPaperController {


    @Autowired
    private SickPaperService sickPaperService;

    @ApiOperation(value = "查询请假单",notes = "查询请假单的分页信息")
    @GetMapping("/findPage")
    public PageVo<SickPaper> findPage(SickPaperVo sickPaperVo){
        PageVo<SickPaper> page = sickPaperService.findPage(sickPaperVo);
        return page;
    }
    @ApiOperation(value = "添加请假单",notes = "添加用户的请假单")
    @PostMapping("/add")
    public ResultVo add(SickPaperVo sickPaperVo){
        try {
            sickPaperService.add(sickPaperVo);
            return ResultVo.OK(ResultEnum.ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.ERROR(ResultEnum.ADD_FAIL);
        }
    }
    @ApiOperation(value = "更新请假单",notes = "更新用户的请假单信息")
    @PostMapping("/update")
    public ResultVo update(SickPaperVo sickPaperVo){
        try {
            sickPaperService.update(sickPaperVo);
            return ResultVo.OK(ResultEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.ERROR(ResultEnum.UPDATE_FAIL);
        }
    }

    @ApiOperation(value = "删除请假单",notes = "删除用户的请假单")
    @GetMapping("/delete")
    public ResultVo delete(SickPaperVo sickPaperVo){
        try {
            sickPaperService.delete(sickPaperVo);
            return ResultVo.OK(ResultEnum.DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.ERROR(ResultEnum.DELETE_FAIL);
        }
    }



}
