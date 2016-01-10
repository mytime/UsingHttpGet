import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 */
public class TestGet {
    public static void main(String[] args) {

        //输出数据后,可再控制台复制数据保存到文本,格式化后查看数据格式,
        new ReadByGet().start();

        //
    }


}


//创建一个线程

class ReadByGet extends Thread {
    @Override
    public void run() {

        try {


            //定义URL对象
            //doctype 可指定 json, xml
            URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=cheboa-test&key=1383843413&type=data&doctype=xml&version=1.1&q=welcome");

            //打开连接
            //定义URLConnection对象接收返回值
            URLConnection connection = url.openConnection();
            //获得网络连接的输入流(字节流)
            InputStream is = connection.getInputStream();
            //准备读取数据流,并指字符流编码是utf-8(字符流)
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            //缓冲读取
            BufferedReader br = new BufferedReader(isr);


            //临时保存数据
            String line;
            //字符串生成器
            StringBuilder builder = new StringBuilder();

            while ((line = br.readLine()) != null) {
                builder.append(line);
            }

            //关闭
            br.close();
            isr.close();
            is.close();

            //输出
            System.out.println(builder.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
