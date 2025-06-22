package com.hl.book_stall.controller;

import com.hl.book_stall.entity.Tops;
import com.hl.book_stall.service.GoodService;
import com.hl.book_stall.service.TopService;
import com.hl.book_stall.service.TypeService;
import com.hl.book_stall.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author hl
 * @date 2025/2/19
 */
//Controller注解用于标识该类是一个控制器类，前后端没分离时使用该注解
// 前后端分离后react需返回JSON格式的数据，使用restful格式的注解
@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private static final int rows = 16; // 默认每页数量
    private final TopService topService;
    private final GoodService goodService;
    private final TypeService typeService;

    /**
     * 首页
     * @return
     */
    //前后端没分离时的写法，直接返回的jsp页面
    // @RequestMapping("/index")
    // public String index(HttpServletRequest request){
    //     request.setAttribute("flag", 1);
    //     request.setAttribute("typeList", typeService.getList());
    //     request.setAttribute("top1List", topService.getList(Tops.TYPE_SCROLL, 1, 1));
    //     request.setAttribute("top2List", topService.getList(Tops.TYPE_LARGE, 1, 6));
    //     request.setAttribute("top3List", topService.getList(Tops.TYPE_SMALL, 1, 8));
    //     return "/index/index.jsp";
    // }

    //前后端分离时的写法，返回JSON格式的数据
    //@RequestMapping是一个通用的请求映射注解，可以处理所有HTTP方法（GET、POST、PUT、DELETE等）的请求。
    //@GetMapping是@RequestMapping的一个特定变体，用于处理HTTP GET请求。
    // @GetMapping("/index")
    // public Map<String, Object> getIndexData() {
    //     Map<String, Object> context = new HashMap<>();
    //     context.put("flag", 1);
    //     context.put("typeList", typeService.getList());
    //     context.put("top1List", topService.getList(Tops.TYPE_SCROLL, 1, 1));
    //     context.put("top2List", topService.getList(Tops.TYPE_LARGE, 1, 6));
    //     context.put("top3List", topService.getList(Tops.TYPE_SMALL, 1, 8));
    //     return context; // 返回 JSON 数据
    // }


    /**
     * 推荐列表
     * @return
     */
    // @RequestMapping("/top")
    // public String tops(int typeid, @RequestParam(required=false, defaultValue="1")int page, HttpServletRequest request) {
    //     request.setAttribute("flag", typeid==2 ? 7 : 8);
    //     request.setAttribute("typeList", typeService.getList());
    //     request.setAttribute("goodList", goodService.getList(typeid, page, rows));
    //     request.setAttribute("pageTool", PageUtil.getPageTool(request, goodService.getTotal(typeid), page, rows));
    //     return "/index/goods.jsp";
    // }
    @GetMapping("/top")
    public Map<String, Object> getTopGoods(
            @RequestParam int typeid,
            @RequestParam(required = false, defaultValue = "1") int page,
            HttpServletRequest request
    ) {
        Map<String, Object> response = new HashMap<>();

        // 设置推荐标志
        response.put("flag", typeid == 2 ? 7 : 8);

        // 设置分类列表
        response.put("typeList", typeService.getList());

        // // 设置商品列表
        // response.put("goodList", goodService.getList(typeid, page, rows));
        //
        // // 设置分页工具
        // response.put("pageTool", PageUtil.getPageTool(request, goodService.getTotal(typeid), page, rows));

        return response; // 返回 JSON 数据
    }


    /**
     * 商品列表
     * @return
     */
    // @RequestMapping("/goods")
    // public String goods(int typeid, @RequestParam(required=false, defaultValue="1")int page, HttpServletRequest request){
    //     request.setAttribute("flag", 2);
    //     if (typeid > 0) {
    //         request.setAttribute("type", typeService.get(typeid));
    //     }
    //     request.setAttribute("typeList", typeService.getList());
    //     request.setAttribute("goodList", goodService.getListByType(typeid, page, rows));
    //     request.setAttribute("pageTool", PageUtil.getPageTool(request, goodService.getTotalByType(typeid), page, rows));
    //     return "/index/goods.jsp";
    // }
    @GetMapping("/goods")
    public Map<String, Object> getGoods(@RequestParam int typeid, @RequestParam(required = false, defaultValue = "1") int page, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        // 设置分类信息
        if (typeid > 0) {
            response.put("type", typeService.get(typeid));
        } else {
            response.put("type", null);
        }

        // 设置分类列表
        response.put("typeList", typeService.getList());

        // 设置商品列表
        response.put("goodList", goodService.getListByType(typeid, page, rows));

        // 设置分页工具
        response.put("pageTool", PageUtil.getPageTool(request, goodService.getTotalByType(typeid), page, rows));

        return response; // 返回 JSON 数据
    }

    /**
     * 商品详情
     * @return
     */
    // @RequestMapping("/detail")
    // public String detail(int goodid, HttpServletRequest request){
    //     request.setAttribute("good", goodService.get(goodid));
    //     request.setAttribute("typeList", typeService.getList());
    //     return "/index/detail.jsp";
    // }
    @GetMapping("/detail")
    public Map<String, Object> getDetail(@RequestParam int goodid) {
        Map<String, Object> response = new HashMap<>();

        // 获取商品详情
        response.put("good", goodService.get(goodid));

        // 获取商品分类列表
        response.put("typeList", typeService.getList());

        return response; // 返回 JSON 数据
    }

    // /**
    //  * 搜索
    //  * @return
    //  */
    // @RequestMapping("/search")
    // public String search(String name, @RequestParam(required=false, defaultValue="1")int page, HttpServletRequest request) {
    //     if (Objects.nonNull(name) && !name.trim().isEmpty()) {
    //         request.setAttribute("goodList", goodService.getListByName(name, page, rows));
    //         request.setAttribute("pageTool", PageUtil.getPageTool(request, goodService.getTotalByName(name), page, rows));
    //     }
    //     request.setAttribute("typeList", typeService.getList());
    //     return "/index/goods.jsp";
    // }
    @GetMapping("/search")
    public Map<String, Object> searchGoods(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "1") int page,
            HttpServletRequest request
    ) {
        Map<String, Object> response = new HashMap<>();

        if (Objects.nonNull(name) && !name.trim().isEmpty()) {
            response.put("goodList", goodService.getListByName(name, page, rows));
            response.put("pageTool", PageUtil.getPageTool(request, goodService.getTotalByName(name), page, rows));
        }

        response.put("typeList", typeService.getList());
        return response; // 返回 JSON 数据
    }

}
