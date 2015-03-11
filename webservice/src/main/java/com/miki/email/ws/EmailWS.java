package com.miki.email.ws;

import com.miki.email.vo.mail.MailVO;
import com.miki.email.vo.NotificationVO;
import com.miki.email.service.IEmailService;
import com.miki.email.vo.mail.SearchEmailVO;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miki on 09.03.2015.
 */
@Path("/email")
public class EmailWS implements IEmailService {

    @POST
    @Path("/send")
    @Produces("application/json")
    @Consumes("application/json")
    @Override
    public NotificationVO send(MailVO mailVO) {
        return NotificationVO.SUCCESS;
    }

    @POST
    @Path("/receive")
    @Override
    @Produces("application/json")
    @Consumes("application/json")
    public List<MailVO> receive(SearchEmailVO searchEmail) {
       return new ArrayList<MailVO>(){{

           MailVO mailVO = new MailVO();
           mailVO.setSubject("ceva");
           mailVO.setMessage("mesaj");
           add(mailVO);

       }
       };
    }
}
