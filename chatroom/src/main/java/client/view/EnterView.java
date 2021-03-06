package client.view;

import client.ChatClient;
import com.alibaba.druid.util.StringUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import message.LoginRequestMessage;
import message.LogoutRequestMessage;
import message.Message;
import message.SignInRequestMessage;

import java.util.Scanner;

import static client.ChatClient.*;

@Slf4j
public class EnterView {
    public EnterView(ChannelHandlerContext ctx){

        while(true){
            ByteBuf buf=ctx.alloc().buffer();
            System.out.println("\n\t+-----------------+");
            System.out.println("\t|   1   登录       |");
            System.out.println("\t+-----------------+");
            System.out.println("\t|   2   注册       |");
            System.out.println("\t+-----------------+");
            System.out.println("\t|   0   退出系统    |");
            System.out.println("\t+-----------------+\n");
            System.out.println("输入你的选择：");
            Scanner scanner=new Scanner(System.in);
            String s=scanner.nextLine();
            while(!StringUtils.isNumber(s)){
                System.out.println("输入不规范，请重新输入用户ID：");
                s=scanner.nextLine();
            }
            switch (Integer.parseInt(s)){
                case 1:
                    System.out.println("请输入用户ID：");
                    String s1=scanner.nextLine();
                    while(!StringUtils.isNumber(s1)){
                        System.out.println("输入不规范，请重新输入用户ID：");
                        s1=scanner.nextLine();
                    }
                    int userID= Integer.parseInt(s1);
                    ChatClient.myUserID=userID;
                    System.out.println("请输入密码：");
                    String password=scanner.nextLine();
                    System.out.println("username="+userID+", password="+password);

                    LoginRequestMessage message=new LoginRequestMessage(userID,password);
                    ctx.writeAndFlush(message);
                    try {
                        synchronized (waitMessage){
                            waitMessage.wait();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(waitSuccess==1){
                        new MainView(ctx);
                    }
                /*Message.LoginResponseMessage.await();
                log.info("会执行到这里吗？？？");*/

                    break;
                case 2:
                    System.out.println("请输入用户名称(<=50位)：");
                    String username= scanner.nextLine();
                    while(username.length()>=50){
                        System.out.println("名称过长，请重新输入用户名称：");
                        username= scanner.nextLine();
                    }
                    System.out.println("请输入密码：");
                    String password1=scanner.nextLine();
                    System.out.println("请输入邮箱地址：");
                    String mail=scanner.nextLine();
                    while(mail.length()>=50){
                        System.out.println("名称过长，请重新输入用户名称：");
                        mail=scanner.nextLine();
                    }
                    log.info("username={}, password={}, mail={}",username,password1,mail);
                    SignInRequestMessage message1=new SignInRequestMessage(username,password1,mail);
                    ctx.writeAndFlush(message1);
                    try {
                        synchronized (waitMessage){
                            waitMessage.wait();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    System.out.println("\t-----正在退出系统-----");
                    ctx.channel().close();
                    return;
            }
        }
    }
}
