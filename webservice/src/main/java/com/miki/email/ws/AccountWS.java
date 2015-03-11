package com.miki.email.ws;

import com.miki.email.service.IAccountService;
import com.miki.email.vo.NotificationVO;
import com.miki.email.vo.account.AccountVO;
import com.miki.email.vo.account.SessionVO;

import javax.ws.rs.*;

/**
 * Created by miki on 09.03.2015.
 */
@Path("/account")
public class AccountWS implements IAccountService{


    @POST
    @Path("/login")
    @Produces("application/json")
    @Consumes("application/json")
    @Override
    public SessionVO login(AccountVO account)  {
        return null;
    }

    @POST
    @Path("/logout")
    @Produces("application/json")
    @Override
    public NotificationVO logout(SessionVO session) {
        return NotificationVO.SUCCESS;
    }
}
