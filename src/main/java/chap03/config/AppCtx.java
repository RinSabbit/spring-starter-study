package chap03.config;

import chap03.ChangePasswordService;
import chap03.MemberDao;
import chap03.MemberInfoPrinter;
import chap03.MemberListPrinter;
import chap03.MemberPrinter;
import chap03.MemberRegisterService;
import chap03.VersionPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }


    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }


    @Bean
    MemberRegisterService memberRegisterService(){
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePasswordService(){
        ChangePasswordService pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao());
        return pwdSvc;
    }


    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter(memberDao(),memberPrinter());
    }

    @Bean
    public MemberInfoPrinter infoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDao(memberDao());
        infoPrinter.setPrinter(memberPrinter());
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
