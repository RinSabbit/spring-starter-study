package chap03.config;

import chap03.ChangePasswordService;
import chap03.MemberDao;
import chap03.MemberInfoPrinter;
import chap03.MemberListPrinter;
import chap03.MemberPrinter;
import chap03.MemberRegisterService;
import chap03.VersionPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf2 {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    @Bean
    MemberRegisterService memberRegisterService(){
        return new MemberRegisterService(memberDao);
    }

    @Bean
    public ChangePasswordService changePasswordService(){
        ChangePasswordService pwdSvc = new ChangePasswordService();
        return pwdSvc;
    }


    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter(memberDao,memberPrinter);
    }

    @Bean
    public MemberInfoPrinter infoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }

}
