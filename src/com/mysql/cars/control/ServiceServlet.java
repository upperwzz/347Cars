package com.mysql.cars.control;

<<<<<<< HEAD
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.cars.model.ServiceDAO;
import com.mysql.cars.model.Service;

/**
 * Servlet implementation class ServiceServlet
 */
@WebServlet("/ServiceServlet")
@MultipartConfig //采用流的方式提交表单内容
public class ServiceServlet extends HttpServlet {
	private ServiceDAO  dao=new ServiceDAO();
	private String userid;
	/**
	 * Servlet复用
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//只要调用ServiceServlet 都会进入这个方法， 然后再根据用户传过来的method参数做分流
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		switch (method) {
			case "listAll":
			{
				System.out.println("查看所有的");
				//查询数据库获得所有二手车辆信息然后返回到页面上显示
				List<Service> services=dao.listAllServices();
				
				//讲查询的数据存储到request范围内
				request.setAttribute("services", services);
				
				//数据存储完毕，跳转到页面上准备在页面上显示所有二手车信息
				request.getRequestDispatcher("serviceList.jsp").forward(request, response);
				
				
				break;
			}
			case "add":
			{
				System.out.println("添加");
				//1.获取表单页面上用户填写的数据
				String pingpaiming=request.getParameter("pingpaiming");
				String xilie=request.getParameter("xilie");
				String userid=request.getParameter("userid");
				String username=request.getParameter("username");
				String zhaopian=request.getParameter("zhaopian");
				String baoxian=request.getParameter("baoxian");
				String fuzeren=request.getParameter("fuzeren");
				
				
				
				//读取上传表单页面上的数据并将图像存储到服务器磁盘上，然后将图片路径添加到数据库里面，实现图片上传功能
				String zhaopian1="images/001.jpg";
				if(request.getPart("zhaopian")!=null) {
					Part  part=request.getPart("zhaopian");
					String fileName=part.getSubmittedFileName();
					InputStream  inputStream=part.getInputStream();
					String uuidName=UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
					File newFile= new File(request.getRealPath("images"),"service/"+uuidName);
					FileOutputStream  outputStream=new  FileOutputStream(newFile);
					byte[] bs=new byte[1024];
					int length=-1;
					while((length=inputStream.read(bs))!=-1) {
						outputStream.write(bs,0,length);
						outputStream.flush();
					}
					outputStream.close();
					 zhaopian1="images/service/"+uuidName;
				}
				
				
				//2.将这些属性封装成一个java对象
				Service  service=new Service();
				service.setUserid(Integer.parseInt(userid));
				service.setUsername(username);
				service.setZhaopian(zhaopian1);
				service.setPingpaiming(pingpaiming);
				service.setXilie(xilie);
				service.setBaoxain(baoxian);
				service.setFuzeren(Integer.parseInt(fuzeren));
				
				//3.调用dao方法，讲这个新添加的汽车信息插入到数据库表中
				boolean result=dao.addService(service);
				
				//4.根据添加结果跳转页面
				if(result) {
					request.getRequestDispatcher("ServiceServlet?method=listAll").forward(request, response);
				}else {
					request.getRequestDispatcher("serviceAdd.jsp").forward(request, response);
				}
				break;
			}
			case "getServiceInfo":
			{
				System.out.println("修改前的查询");
				//1.获取用户超链接传过来的汽车编号
				String serviceid=request.getParameter("userid");
				//2.调用dao查询出这个车辆信息
				Service service=dao.getServiceDetailById(Integer.parseInt(userid));
				//3.将查询出来的汽车存储到request范围内
				request.setAttribute("service", service);
				//4.跳转到修改的jsp上显示这个车辆数据供用户修改操作
				request.getRequestDispatcher("serviceEdit.jsp").forward(request, response);
				break;
			}
			case "update":
			{
				System.out.println("修改");
				//1.还是先获取页面上用户修改后的车辆信息
				String pingpaiming=request.getParameter("pingpaiming");
				String xilie=request.getParameter("xilie");
				String userid=request.getParameter("userid");
				String username=request.getParameter("username");
				String zhaopian=request.getParameter("zhaopian");
				String baoxian=request.getParameter("baoxian");
				String fuzeren=request.getParameter("fuzeren");
				
				//2.将这些属性封装成一个java对象
				Service  service=new Service();
				service.setUserid(Integer.parseInt(userid));
				service.setUsername(username);
				service.setZhaopian(zhaopian);
				service.setPingpaiming(pingpaiming);
				service.setXilie(xilie);
				service.setBaoxain(baoxian);
				service.setFuzeren(Integer.parseInt(fuzeren));
				
				//3.调用dao方法，将这个新添加的汽车信息插入到数据库表中
				boolean result=dao.updateService(service);
				
				//4.根据修改结果跳转页面
				if(result) {
					request.getRequestDispatcher("ServiceServlet?method=listAll").forward(request, response);
				}else {
					request.getRequestDispatcher("serviceEdit.jsp").forward(request, response);
				}
				break;
			}
			case "delete":
			{
				System.out.println("删除");
				//1.获取用户超链接传过来的汽车编号
				String serviceid=request.getParameter("serviceid");
				//2.调用dao方法将这个编号的车辆删除掉
				boolean result=dao.deleteService(Integer.parseInt(serviceid));
				//3.将删除的结果存储到request范围内，然后再jsp上判断结果提示用户操作结果
				request.setAttribute("deleteResult", result);
				//4.跳转到列表页面
				request.getRequestDispatcher("ServiceServlet?method=listAll").forward(request, response);
				break;
			}
	
		}
	}
}
=======
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceServlet
 */
@WebServlet("/ServiceServlet")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
>>>>>>> branch 'master' of https://github.com/upperwzz/347Cars.git
