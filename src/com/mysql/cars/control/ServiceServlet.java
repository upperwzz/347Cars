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
@MultipartConfig //�������ķ�ʽ�ύ������
public class ServiceServlet extends HttpServlet {
	private ServiceDAO  dao=new ServiceDAO();
	private String userid;
	/**
	 * Servlet����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ֻҪ����ServiceServlet ���������������� Ȼ���ٸ����û���������method����������
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		switch (method) {
			case "listAll":
			{
				System.out.println("�鿴���е�");
				//��ѯ���ݿ������ж��ֳ�����ϢȻ�󷵻ص�ҳ������ʾ
				List<Service> services=dao.listAllServices();
				
				//����ѯ�����ݴ洢��request��Χ��
				request.setAttribute("services", services);
				
				//���ݴ洢��ϣ���ת��ҳ����׼����ҳ������ʾ���ж��ֳ���Ϣ
				request.getRequestDispatcher("serviceList.jsp").forward(request, response);
				
				
				break;
			}
			case "add":
			{
				System.out.println("���");
				//1.��ȡ��ҳ�����û���д������
				String pingpaiming=request.getParameter("pingpaiming");
				String xilie=request.getParameter("xilie");
				String userid=request.getParameter("userid");
				String username=request.getParameter("username");
				String zhaopian=request.getParameter("zhaopian");
				String baoxian=request.getParameter("baoxian");
				String fuzeren=request.getParameter("fuzeren");
				
				
				
				//��ȡ�ϴ���ҳ���ϵ����ݲ���ͼ��洢�������������ϣ�Ȼ��ͼƬ·����ӵ����ݿ����棬ʵ��ͼƬ�ϴ�����
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
				
				
				//2.����Щ���Է�װ��һ��java����
				Service  service=new Service();
				service.setUserid(Integer.parseInt(userid));
				service.setUsername(username);
				service.setZhaopian(zhaopian1);
				service.setPingpaiming(pingpaiming);
				service.setXilie(xilie);
				service.setBaoxain(baoxian);
				service.setFuzeren(Integer.parseInt(fuzeren));
				
				//3.����dao���������������ӵ�������Ϣ���뵽���ݿ����
				boolean result=dao.addService(service);
				
				//4.������ӽ����תҳ��
				if(result) {
					request.getRequestDispatcher("ServiceServlet?method=listAll").forward(request, response);
				}else {
					request.getRequestDispatcher("serviceAdd.jsp").forward(request, response);
				}
				break;
			}
			case "getServiceInfo":
			{
				System.out.println("�޸�ǰ�Ĳ�ѯ");
				//1.��ȡ�û������Ӵ��������������
				String serviceid=request.getParameter("userid");
				//2.����dao��ѯ�����������Ϣ
				Service service=dao.getServiceDetailById(Integer.parseInt(userid));
				//3.����ѯ�����������洢��request��Χ��
				request.setAttribute("service", service);
				//4.��ת���޸ĵ�jsp����ʾ����������ݹ��û��޸Ĳ���
				request.getRequestDispatcher("serviceEdit.jsp").forward(request, response);
				break;
			}
			case "update":
			{
				System.out.println("�޸�");
				//1.�����Ȼ�ȡҳ�����û��޸ĺ�ĳ�����Ϣ
				String pingpaiming=request.getParameter("pingpaiming");
				String xilie=request.getParameter("xilie");
				String userid=request.getParameter("userid");
				String username=request.getParameter("username");
				String zhaopian=request.getParameter("zhaopian");
				String baoxian=request.getParameter("baoxian");
				String fuzeren=request.getParameter("fuzeren");
				
				//2.����Щ���Է�װ��һ��java����
				Service  service=new Service();
				service.setUserid(Integer.parseInt(userid));
				service.setUsername(username);
				service.setZhaopian(zhaopian);
				service.setPingpaiming(pingpaiming);
				service.setXilie(xilie);
				service.setBaoxain(baoxian);
				service.setFuzeren(Integer.parseInt(fuzeren));
				
				//3.����dao���������������ӵ�������Ϣ���뵽���ݿ����
				boolean result=dao.updateService(service);
				
				//4.�����޸Ľ����תҳ��
				if(result) {
					request.getRequestDispatcher("ServiceServlet?method=listAll").forward(request, response);
				}else {
					request.getRequestDispatcher("serviceEdit.jsp").forward(request, response);
				}
				break;
			}
			case "delete":
			{
				System.out.println("ɾ��");
				//1.��ȡ�û������Ӵ��������������
				String serviceid=request.getParameter("serviceid");
				//2.����dao�����������ŵĳ���ɾ����
				boolean result=dao.deleteService(Integer.parseInt(serviceid));
				//3.��ɾ���Ľ���洢��request��Χ�ڣ�Ȼ����jsp���жϽ����ʾ�û��������
				request.setAttribute("deleteResult", result);
				//4.��ת���б�ҳ��
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
