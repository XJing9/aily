package com.aaa.util;//�ӿ����ͣ��������ߴ������Žӿڣ�֧�ַ�����֤����š�����֪ͨ���ŵȡ�
// �˻�ע�᣺��ͨ���õ�ַ��ͨ�˻�http://sms.ihuyi.com/register.html
// ע�����
//��1�������ڼ䣬����Ĭ�ϵ�ģ����в��ԣ�Ĭ��ģ������ӿ��ĵ���
//��2����ʹ��APIID���鿴APIID���¼�û�����->��֤�����->��Ʒ����->APIID���� APIkey�����ýӿڣ�
//��3���ô���������뻥�����߶��Žӿڲο�ʹ�ã��ͻ��ɸ���ʵ����Ҫ���б�д��

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;

public class Sendsms {

	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

	public Integer PhoneCode(String cus_phone) {

		/*HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");

		int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);

		String content = new String("������֤���ǣ�" + mobile_code + "���벻Ҫ����֤��й¶�������ˡ�");

		NameValuePair[] data = {//�ύ����
				new NameValuePair("account", "C15000643"), //�鿴�û����ǵ�¼�û�����->��֤�����->��Ʒ����->APIID
				new NameValuePair("password", " 8b2721a0df66e967e306e35897931f65"),  //�鿴�������¼�û�����->��֤�����->��Ʒ����->APIKEY
				//new NameValuePair("password", util.StringUtil.MD5Encode("����")),
				new NameValuePair("mobile", cus_phone),
				new NameValuePair("content", content),
		};
		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult = method.getResponseBodyAsString();

			//System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			if ("2".equals(code)) {
				System.out.println("�����ύ�ɹ�");
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Integer mobile_code=123;
		return mobile_code;
	}
}