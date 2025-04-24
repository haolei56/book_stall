package com.hl.book_stall.controller;

import com.hl.book_stall.entity.Goods;
import com.hl.book_stall.entity.Items;
import com.hl.book_stall.entity.Orders;
import com.hl.book_stall.entity.Users;
import com.hl.book_stall.service.GoodService;
import com.hl.book_stall.service.OrderService;
import com.hl.book_stall.service.TypeService;
import com.hl.book_stall.service.UserService;
import com.hl.book_stall.util.SafeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author hl
 * @date 2025/2/19
 */
@Controller
@RequestMapping("/index")
public class UserController{

    private static final String INDENT_KEY = "order";

    @Resource
    private UserService userService;
    @Resource
    private OrderService orderService;
    @Resource
    private GoodService goodService;
    @Resource
    private TypeService typeService;


    // /**
    //  * 注册用户
    //  * @return
    //  */
    // @RequestMapping("/register")
    // public String register(@RequestParam(required=false, defaultValue="0")int flag, Users user, Model model){
    //     model.addAttribute("typeList", typeService.getList());
    //     if(flag==-1) {
    //         model.addAttribute("flag", 5); // 注册页面
    //         return "/index/register.jsp";
    //     }
    //     if (user.getUsername().isEmpty()) {
    //         model.addAttribute("msg", "用户名不能为空!");
    //         return "/index/register.jsp";
    //     }else if (userService.isExist(user.getUsername())) {
    //         model.addAttribute("msg", "用户名已存在!");
    //         return "/index/register.jsp";
    //     }else {
    //         String password = user.getPassword();
    //         userService.add(user);
    //         user.setPassword(password);
    //         return "redirect:login?flag=-1"; // 注册成功后转去登录
    //     }
    // }
    /**
     * 注册用户
     * @return
     */
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Users user) {
        Map<String, Object> response = new HashMap<>();

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            response.put("status", "error");
            response.put("message", "用户名不能为空!");
            return response;
        }

        if (userService.isExist(user.getUsername())) {
            response.put("status", "error");
            response.put("message", "用户名已存在!");
            return response;
        }

        userService.add(user);
        response.put("status", "ok");
        response.put("redirect", "/login?flag=-1"); // 注册成功后跳转到登录页面
        return response;
    }

    /**
     * 用户登录
     * @return
     */
    // @RequestMapping("/login")
    // public String login(@RequestParam(required=false, defaultValue="0")int flag, Users user, HttpSession session, Model model) {
    //     model.addAttribute("typeList", typeService.getList());
    //     if(flag==-1) {
    //         flag = 6; // 登录页面
    //         return "/index/login.jsp";
    //     }
    //     if(userService.checkUser(user.getUsername(), user.getPassword())){
    //         session.setAttribute("user", userService.get(user.getUsername()));
    //         return "redirect:index";
    //     } else {
    //         model.addAttribute("msg", "用户名或密码错误!");
    //         return "/index/login.jsp";
    //     }
    // }

    /**
     * 注销登录
     * @return
     */
    // @RequestMapping("/logout")
    // public String logout(HttpSession session) {
    //     session.removeAttribute("user");
    //     session.removeAttribute("order");
    //     return "/index/login.jsp";
    // }
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Users user, HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        if (userService.checkUser(user.getUsername(), user.getPassword())) {
            session.setAttribute("user", userService.get(user.getUsername()));
            response.put("status", "ok");
            response.put("redirect", "/index");
        } else {
            response.put("status", "error");
            response.put("message", "用户名或密码错误!");
        }

        return response; // 返回 JSON 数据
    }

    @PostMapping("/logout")
    public Map<String, String> logout(HttpSession session) {
        Map<String, String> response = new HashMap<>();
        session.removeAttribute("user");
        session.removeAttribute("order");
        response.put("status", "ok");
        response.put("message", "注销成功");
        return response; // 返回 JSON 数据
    }

    // /**
    //  * 查看购物车
    //  * @return
    //  */
    // @RequestMapping("/cart")
    // public String cart(Model model) {
    //     model.addAttribute("typeList", typeService.getList());
    //     return "/index/cart.jsp";
    // }
    //
    // /**
    //  * 购买
    //  * @return
    //  */
    // @RequestMapping("/buy")
    // public @ResponseBody String buy(int goodid, HttpSession session){
    //     Goods goods = goodService.get(goodid);
    //     if (goods .getStock() <= 0) { // 库存不足
    //         return "empty";
    //     }
    //     Orders order = (Orders) session.getAttribute(INDENT_KEY);
    //     if (order==null) {
    //         session.setAttribute(INDENT_KEY, orderService.add(goods));
    //     }else {
    //         session.setAttribute(INDENT_KEY, orderService.addOrderItem(order, goods));
    //     }
    //     return "ok";
    // }
    //
    // /**
    //  * 减少
    //  */
    // @RequestMapping("/lessen")
    // public @ResponseBody String lessen(int goodid, HttpSession session){
    //     Orders order = (Orders) session.getAttribute(INDENT_KEY);
    //     if (order != null) {
    //         session.setAttribute(INDENT_KEY, orderService.lessenIndentItem(order, goodService.get(goodid)));
    //     }
    //     return "ok";
    // }
    //
    // /**
    //  * 删除
    //  */
    // @RequestMapping("/delete")
    // public @ResponseBody String delete(int goodid, HttpSession session){
    //     Orders order = (Orders) session.getAttribute(INDENT_KEY);
    //     if (order != null) {
    //         session.setAttribute(INDENT_KEY, orderService.deleteIndentItem(order, goodService.get(goodid)));
    //     }
    //     return "ok";
    // }
    //
    //
    // /**
    //  * 提交订单
    //  * @return
    //  */
    // @RequestMapping("/save")
    // public String save(ServletRequest request, HttpSession session, Model model){
    //     model.addAttribute("typeList", typeService.getList());
    //     Users user = (Users) session.getAttribute("user");
    //     if (user == null) {
    //         request.setAttribute("msg", "请登录后提交订单!");
    //         return "/index/login.jsp";
    //     }
    //     Orders sessionOrder = (Orders) session.getAttribute(INDENT_KEY);
    //     if (sessionOrder != null) {
    //         if (sessionOrder != null) {
    //             for(Items item : sessionOrder.getItemList()){ // 检测商品库存(防止库存不足)
    //                 Goods product = goodService.get(item.getGoodId());
    //                 if(item.getAmount() > product.getStock()){
    //                     request.setAttribute("msg", "商品 ["+product.getName()+"] 库存不足! 当前库存数量: "+product.getStock());
    //                     return "/index/cart.jsp";
    //                 }
    //             }
    //         }
    //         sessionOrder.setUserId(user.getId());
    //         sessionOrder.setUser(userService.get(user.getId()));
    //         int orderid = orderService.save(sessionOrder);	// 保存订单
    //         session.removeAttribute(INDENT_KEY);	// 清除购物车
    //         return "redirect:topay?orderid="+orderid;
    //     }
    //     request.setAttribute("msg", "处理失败!");
    //     return "/index/cart.jsp";
    // }

    @GetMapping("/cart")
    public Map<String, Object> getCart(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Orders order = (Orders) session.getAttribute(INDENT_KEY);

        // 模拟获取购物车数据
        response.put("msg", "购物车加载成功");
        response.put("order", order);
        response.put("typeList", typeService.getList()); // 获取商品分类列表

        return response; // 返回 JSON 数据
    }

    @PostMapping("/buy")
    public Map<String, String> buy(@RequestParam int goodid, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        Goods goods = goodService.get(goodid);
        if (goods.getStock() <= 0) { // 库存不足
            response.put("status", "empty");
            response.put("message", "库存不足");
            return response;
        }
        Orders order = (Orders) session.getAttribute(INDENT_KEY);
        if (order == null) {
            session.setAttribute(INDENT_KEY, orderService.add(goods));
        } else {
            session.setAttribute(INDENT_KEY, orderService.addOrderItem(order, goods));
        }
        response.put("status", "ok");
        response.put("message", "商品已加入购物车");
        return response;
    }

    @PostMapping("/lessen")
    public Map<String, String> lessen(@RequestParam int goodid, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        Orders order = (Orders) session.getAttribute(INDENT_KEY);
        if (order != null) {
            session.setAttribute(INDENT_KEY, orderService.lessenIndentItem(order, goodService.get(goodid)));
        }
        response.put("status", "ok");
        response.put("message", "商品数量已减少");
        return response;
    }

    @PostMapping("/delete")
    public Map<String, String> delete(@RequestParam int goodid, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        Orders order = (Orders) session.getAttribute(INDENT_KEY);
        if (order != null) {
            session.setAttribute(INDENT_KEY, orderService.deleteIndentItem(order, goodService.get(goodid)));
        }
        response.put("status", "ok");
        response.put("message", "商品已删除");
        return response;
    }

    @PostMapping("/save")
    public Map<String, String> save(HttpServletRequest request, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            response.put("status", "error");
            response.put("message", "请登录后提交订单!");
            return response;
        }
        Orders sessionOrder = (Orders) session.getAttribute(INDENT_KEY);
        if (sessionOrder != null) {
            for (Items item : sessionOrder.getItemList()) { // 检测商品库存
                Goods product = goodService.get(item.getGoodId());
                if (item.getAmount() > product.getStock()) {
                    response.put("status", "error");
                    response.put("message", "商品 [" + product.getName() + "] 库存不足! 当前库存数量: " + product.getStock());
                    return response;
                }
            }
            sessionOrder.setUserId(user.getId());
            sessionOrder.setUser(userService.get(user.getId()));
            int orderid = orderService.save(sessionOrder); // 保存订单
            session.removeAttribute(INDENT_KEY); // 清除购物车
            response.put("status", "ok");
            response.put("redirect", "topay?orderid=" + orderid);
            return response;
        }
        response.put("status", "error");
        response.put("message", "处理失败!");
        return response;
    }

    // /**
    //  * 支付页面
    //  * @return
    //  */
    // @RequestMapping("/topay")
    // public String topay(int orderid, ServletRequest request, Model model) {
    //     model.addAttribute("typeList", typeService.getList());
    //     request.setAttribute("order", orderService.get(orderid));
    //     return "/index/pay.jsp";
    // }
    //
    // /**
    //  * 支付(模拟)
    //  * @return
    //  */
    // @RequestMapping("/pay")
    // public String pay(Orders order, Model model) {
    //     model.addAttribute("typeList", typeService.getList());
    //     orderService.pay(order);
    //     return "redirect:payok?orderid="+order.getId();
    // }

    @GetMapping("/topay")
    public Map<String, Object> getPaymentInfo(@RequestParam int orderid) {
        Map<String, Object> response = new HashMap<>();
        Orders order = orderService.get(orderid);

        if (order == null) {
            response.put("status", "error");
            response.put("message", "订单不存在!");
            return response;
        }

        response.put("status", "ok");
        response.put("order", order);
        return response; // 返回订单信息
    }

    @PostMapping("/pay")
    public Map<String, Object> processPayment(@RequestBody Orders order) {
        Map<String, Object> response = new HashMap<>();

        try {
            orderService.pay(order); // 模拟支付逻辑
            response.put("status", "ok");
            response.put("redirect", "/payok?orderid=" + order.getId());
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "支付失败，请稍后再试!");
        }

        return response; // 返回支付结果
    }

    // /**
    //  * 支付成功
    //  * @return
    //  */
    // @RequestMapping("/payok")
    // public String payok(int orderid, ServletRequest request, Model model) {
    //     model.addAttribute("typeList", typeService.getList());
    //     Orders order = orderService.get(orderid);
    //     int paytype = order.getPaytype();
    //     if(paytype == Orders.PAYTYPE_WECHAT || paytype == Orders.PAYTYPE_ALIPAY) {
    //         request.setAttribute("msg", "订单["+orderid+"]支付成功");
    //     }else {
    //         request.setAttribute("msg", "订单["+orderid+"]货到付款");
    //     }
    //     return "/index/payok.jsp";
    // }

    @GetMapping("/payok")
    public Map<String, Object> getPaymentSuccessInfo(@RequestParam int orderid) {
        Map<String, Object> response = new HashMap<>();
        Orders order = orderService.get(orderid);

        if (order == null) {
            response.put("status", "error");
            response.put("message", "订单不存在!");
            return response;
        }

        int paytype = order.getPaytype();
        String msg;
        if (paytype == Orders.PAYTYPE_WECHAT || paytype == Orders.PAYTYPE_ALIPAY) {
            msg = "订单 [" + orderid + "] 支付成功";
        } else {
            msg = "订单 [" + orderid + "] 货到付款";
        }

        response.put("status", "ok");
        response.put("message", msg);
        return response; // 返回支付成功信息
    }

    // /**
    //  * 查看订单
    //  * @return
    //  */
    // @RequestMapping("/order")
    // public String order(HttpSession session, Model model){
    //     model.addAttribute("flag", 3);
    //     model.addAttribute("typeList", typeService.getList());
    //     Users user = (Users) session.getAttribute("user");
    //     if (user == null) {
    //         model.addAttribute("msg", "请登录后查看订单!");
    //         return "/index/login.jsp";
    //     }
    //     List<Orders> orderList = orderService.getListByUserid(user.getId());
    //     if (orderList!=null && !orderList.isEmpty()) {
    //         for(Orders order : orderList){
    //             order.setItemList(orderService.getItemList(order.getId()));
    //         }
    //     }
    //     model.addAttribute("orderList", orderList);
    //     return "/index/order.jsp";
    // }
    @GetMapping("/order")
    public Map<String, Object> getOrder(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            response.put("status", "error");
            response.put("message", "请登录后查看订单!");
            return response;
        }

        List<Orders> orderList = orderService.getListByUserid(user.getId());
        if (orderList != null && !orderList.isEmpty()) {
            for (Orders order : orderList) {
                order.setItemList(orderService.getItemList(order.getId()));
            }
        }

        response.put("status", "ok");
        response.put("orderList", orderList);
        return response; // 返回 JSON 数据
    }


    /**
     * 个人信息
     * @return
     */
    // @RequestMapping("/my")
    // public String my(Users user, HttpSession session, Model model){
    //     model.addAttribute("flag", 4);
    //     model.addAttribute("typeList", typeService.getList());
    //     Users userLogin = (Users) session.getAttribute("user");
    //     if (userLogin == null) {
    //         model.addAttribute("msg", "请先登录!");
    //         return "/index/login.jsp";
    //     }
    //     // 进入个人中心
    //     if (Objects.isNull(user) || Objects.isNull(user.getId())) {
    //         return "/index/my.jsp";
    //     }
    //     Users u = userService.get(user.getId());
    //     // 修改资料
    //     u.setName(user.getName());
    //     u.setPhone(user.getPhone());
    //     u.setAddress(user.getAddress());
    //     userService.update(u);  // 更新数据库
    //     session.setAttribute("user", u); // 更新session
    //     model.addAttribute("msg", "信息修改成功!");
    //     // 修改密码
    //     if(user.getPasswordNew()!=null && !user.getPasswordNew().trim().isEmpty()) {
    //         if (user.getPassword()!=null && !user.getPassword().trim().isEmpty()
    //                 && SafeUtil.encode(user.getPassword()).equals(u.getPassword())) {
    //             if (user.getPasswordNew()!=null && !user.getPasswordNew().trim().isEmpty()) {
    //                 u.setPassword(SafeUtil.encode(user.getPasswordNew()));
    //             }
    //             userService.update(u);  // 更新数据库
    //             session.setAttribute("user", u); // 更新session
    //             model.addAttribute("msg", "密码修改成功!");
    //         }else {
    //             model.addAttribute("msg", "原密码错误!");
    //         }
    //     }
    //     return "/index/my.jsp";
    // }
    @GetMapping("/user")
    public Map<String, Object> getUser(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Users user = (Users) session.getAttribute("user");
        if (user != null) {
            response.put("status", "ok");
            response.put("user", user);
        } else {
            response.put("status", "error");
            response.put("message", "用户未登录");
        }
        return response;
    }

    @PostMapping("/user/update")
    public Map<String, String> updateUser(@RequestBody Users user, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        Users u = (Users) session.getAttribute("user");
        if (u == null) {
            response.put("status", "error");
            response.put("message", "用户未登录");
            return response;
        }

        // 更新收货信息
        u.setPhone(user.getPhone());
        u.setAddress(user.getAddress());
        userService.update(u); // 更新数据库
        session.setAttribute("user", u); // 更新 session
        response.put("status", "ok");
        response.put("message", "信息修改成功");

        // 修改密码
        if (user.getPasswordNew() != null && !user.getPasswordNew().trim().isEmpty()) {
            if (user.getPassword() != null && !user.getPassword().trim().isEmpty()
                    && SafeUtil.encode(user.getPassword()).equals(u.getPassword())) {
                u.setPassword(SafeUtil.encode(user.getPasswordNew()));
                userService.update(u); // 更新数据库
                session.setAttribute("user", u); // 更新 session
                response.put("message", "密码修改成功");
            } else {
                response.put("status", "error");
                response.put("message", "原密码错误");
            }
        }

        return response;
    }

}
