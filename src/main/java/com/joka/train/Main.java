package com.joka.train;

import com.joka.train.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created on 2021/4/26 21:22.
 *
 * @author zhaozengjie
 * Description :
 */
@Slf4j
public class Main {

    public static void main(String[] args) {


        String url = "https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2021-04-30&leftTicketDTO.from_station=SZQ&leftTicketDTO.to_station=OTQ&purpose_codes=ADULT";

        String cookie = "_uab_collina=161875931089362454803888; JSESSIONID=89F1C504124CF9C6AFFC3FB313FEA100; _jc_save_fromStation=%u6DF1%u5733%2CSZQ; _jc_save_wfdc_flag=dc; _jc_save_toStation=%u6C55%u5934%2COTQ; _jc_save_fromDate=2021-04-30; route=c5c62a339e7744272a54643b3be5bf64; BIGipServerotn=451412234.24610.0000; _jc_save_toDate=2021-04-26; RAIL_EXPIRATION=1619727394733; RAIL_DEVICEID=re2Uig3nizlJrCiUFTdzcW4uO07uex_9EKNcZJYeYpIagVf5_gwLTcf7wYoNGFlftozlml0g6JIBvmrRlvARCJhd9RiRmcJv578m_EIAIHFk0UdYHybCiCu8RMIH0ybKbNyy2pw2WXKF9H5AajLieaFKOWYHwiuh";
        Headers headers = Headers.of("Cookie",cookie);

        HttpUtils.doGetAsync(url, headers, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                log.info("resp :{}",string);
            }
        });

    }

}
