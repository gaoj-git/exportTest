import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestDemo {

    public static void main(String[] args) {
        //读取文件
        Map<String,Object> map = new HashMap<>();
        File file = new File("d://test1.docx");
        FileOutputStream fileOutputStream = null;
        XWPFTemplate template = null;
        try {
            //输出打钩效果demo
            fileOutputStream = new FileOutputStream(file);
            map.put("test",new TextRenderData("R",new Style("Wingdings 2",14)));
            template = XWPFTemplate.compile(System.getProperty("user.dir")+"/test.docx").render(map);
            template.write(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
