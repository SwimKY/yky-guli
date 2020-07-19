package com.yky.serviceedu.controller;


import com.yky.commonutils.R;
import com.yky.serviceedu.entity.EduTeacher;
import com.yky.serviceedu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author yky
 * @since 2020-07-04
 */
@RestController
@RequestMapping("/serviceedu/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("/findAll")
    public R findAll(){
        List<EduTeacher> list = eduTeacherService.list(null);
        System.out.println("nihao");
        return R.ok().data("items",list);
    }

    @DeleteMapping("/delete/{id}")
    public R deleteTeacher(@PathVariable("id") String id){
        boolean flag = eduTeacherService.removeById(id);
       if(flag){
           return R.ok();
       }else {
           return R.error();
       }
    }
}

