package com.example.kqxs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckTicketService {
    private ResultKQXSService resultKQXSService;
    public CheckTicketService(){
    }

    public static List<TicketModel> getListTicket(){
        List<TicketModel> tickets = new ArrayList<>();
        tickets.add(new TicketModel("238481",2,"Xổ số Cần Thơ", new Date(2023,5,24)));
        tickets.add(new TicketModel("535921",2,"Xổ số Hậu Giang", new Date(2023,5,24)));
        tickets.add(new TicketModel("476085",2,"Xổ số Đồng Nai", new Date(2023,2,2)));
        return tickets;
    }

    public List<TicketModel> kiemTraTrungGiai(List<TicketModel> tickets) {
        for(TicketModel ticket: tickets){
            resultKQXSService = new ResultKQXSService(ticket);
            if(checkSpecialPrize(ticket)){
                System.out.println(ticket.getSoTrungThuong() + "Trúng G.DB");
                ticket.setKetQuaXo("Trúng G.ĐB");
            }else if(checkFirstPrize(ticket)){
                System.out.println(ticket.getSoTrungThuong() + "Trúng G1");
                if(ticket.getKetQuaXo().equals("Đang đợi")){
                    ticket.setKetQuaXo("Trúng G.1");
                }else{
                    ticket.setKetQuaXo(ticket.getKetQuaXo() + ", G.1");
                }
            }else if(checkSecondPrize(ticket)){
                System.out.println(ticket.getSoTrungThuong() + "Trúng G.2");
                if(ticket.getKetQuaXo().equals("Đang đợi")){
                    ticket.setKetQuaXo("Trúng G.2");
                }else{
                    ticket.setKetQuaXo(ticket.getKetQuaXo() + ", G.2");
                }
            }else if(checkThirdPrize(ticket)){
                System.out.println(ticket.getSoTrungThuong() + "Trúng G.3");
                if(ticket.getKetQuaXo().equals("Đang đợi")){
                    ticket.setKetQuaXo("Trúng G.3");
                }else{
                    ticket.setKetQuaXo(ticket.getKetQuaXo() + ", G.3");
                }
            }else if(checkFourthPrize(ticket)){
                System.out.println(ticket.getSoTrungThuong() + "Trúng G.4");
                if(ticket.getKetQuaXo().equals("Đang đợi")){
                    ticket.setKetQuaXo("Trúng G.4");
                }else{
                    ticket.setKetQuaXo(ticket.getKetQuaXo() + ", G.4");
                }
            }else if(checkFifthPrize(ticket)){
                System.out.println(ticket.getSoTrungThuong() + "Trúng G.5");
                if(ticket.getKetQuaXo().equals("Đang đợi")){
                    ticket.setKetQuaXo("Trúng G.5");
                }else{
                    ticket.setKetQuaXo(ticket.getKetQuaXo() + ", G.5");
                }
            }else if(checkSixthPrize(ticket)){
                System.out.println(ticket.getSoTrungThuong() + "Trúng G.6");
                if(ticket.getKetQuaXo().equals("Đang đợi")){
                    ticket.setKetQuaXo("Trúng G.6");
                }else{
                    ticket.setKetQuaXo(ticket.getKetQuaXo() + ", G.6");
                }
            }else if(checkSeventhPrize(ticket)){
                System.out.println(ticket.getSoTrungThuong() + "Trúng G.7");
                if(ticket.getKetQuaXo().equals("Đang đợi")){
                    ticket.setKetQuaXo("Trúng G.7");
                }else{
                    ticket.setKetQuaXo(ticket.getKetQuaXo() + ", G.7");
                }
            }else if(checkEighthPrize(ticket)){
                System.out.println(ticket.getSoTrungThuong() + "Trúng G.8");
                if(ticket.getKetQuaXo().equals("Đang đợi")){
                    ticket.setKetQuaXo("Trúng G.8");
                }else{
                    ticket.setKetQuaXo(ticket.getKetQuaXo() + ", G.8");
                }
            }else{
                System.out.println(ticket.getSoTrungThuong() + "Không trúng");
                Date now = new Date();
                System.out.println("now: " + now.getMonth());
                System.out.println("ve: " + ticket.getNgayXo().getMonth());
                if(ticket.getKetQuaXo().equals("Đang đợi")){
                    if(ticket.getNgayXo().getMonth() >= now.getMonth()+1){
                        if(ticket.getNgayXo().getDate() > now.getDate()){
                            ticket.setKetQuaXo("Đang đợi");
                        }
                    }else if(ticket.getNgayXo().getMonth() < now.getMonth()+1){
                        ticket.setKetQuaXo("Không trúng");
                    }
                }
            }
        }
        return tickets;
    }

    public Boolean checkSpecialPrize(TicketModel ticket){
        String specialPrize = resultKQXSService.getSpecialPrize();
        if(specialPrize.trim().equals(ticket.getSoTrungThuong().trim())){
            return true;
        }
        return false;
    }

    public Boolean checkFirstPrize(TicketModel ticket){
        String firstPrize = resultKQXSService.getFirstPrize();
        int soDo = Integer.parseInt(ticket.getSoTrungThuong().trim()) % 100000;
        String soTrungThuong = "";
        if(soDo < 10){
            soTrungThuong = "0000" + String.valueOf(soDo);
        }else if(soDo < 100){
            soTrungThuong = "000" + String.valueOf(soDo);
        }else if(soDo < 1000){
            soTrungThuong = "00" + String.valueOf(soDo);
        }else if(soDo < 10000){
            soTrungThuong = "0" + String.valueOf(soDo);
        }else if(soDo >= 10000){
            soTrungThuong = String.valueOf(soDo);
        }
        if(firstPrize.trim().equals(soTrungThuong)){
            return true;
        }
        return false;
    }

    public Boolean checkSecondPrize(TicketModel ticket){
        //ResultKQXSService resultKQXSService = new ResultKQXSService(ticket);
        String secondPrize = resultKQXSService.getSecondPrize();
        int soDo = Integer.parseInt(ticket.getSoTrungThuong().trim()) % 100000;
        String soTrungThuong = "";
        if(soDo < 10){
            soTrungThuong = "0000" + String.valueOf(soDo);
        }else if(soDo < 100){
            soTrungThuong = "000" + String.valueOf(soDo);
        }else if(soDo < 1000){
            soTrungThuong = "00" + String.valueOf(soDo);
        }else if(soDo < 10000){
            soTrungThuong = "0" + String.valueOf(soDo);
        }else if(soDo >= 10000){
            soTrungThuong = String.valueOf(soDo);
        }
        if(secondPrize.trim().equals(soTrungThuong)){
            return true;
        }
        return false;
    }

    public Boolean checkThirdPrize(TicketModel ticket){
        //ResultKQXSService resultKQXSService = new ResultKQXSService(ticket);
        String thirdPrize = resultKQXSService.getThirdPrize();
        String[] thirdPrizeArr = thirdPrize.split("-");
        for(String prize: thirdPrizeArr){
            int soDo = Integer.parseInt(ticket.getSoTrungThuong().trim()) % 100000;
            String soTrungThuong = "";
            if(soDo < 10){
                soTrungThuong = "0000" + String.valueOf(soDo);
            }else if(soDo < 100){
                soTrungThuong = "000" + String.valueOf(soDo);
            }else if(soDo < 1000){
                soTrungThuong = "00" + String.valueOf(soDo);
            }else if(soDo < 10000){
                soTrungThuong = "0" + String.valueOf(soDo);
            }else if(soDo >= 10000){
                soTrungThuong = String.valueOf(soDo);
            }
            if(prize.trim().equals(soTrungThuong)){
                return true;
            }
        }
        return false;
    }

    public Boolean checkFourthPrize(TicketModel ticket){
        //ResultKQXSService resultKQXSService = new ResultKQXSService(ticket);
        String fourthPrize = resultKQXSService.getFourthPrize();
        String[] fourthPrizeArr = fourthPrize.split("-");
        for(String prize: fourthPrizeArr){
            int soDo = Integer.parseInt(ticket.getSoTrungThuong().trim()) % 100000;
            String soTrungThuong = "";
            if(soDo < 10){
                soTrungThuong = "0000" + String.valueOf(soDo);
            }else if(soDo < 100){
                soTrungThuong = "000" + String.valueOf(soDo);
            }else if(soDo < 1000){
                soTrungThuong = "00" + String.valueOf(soDo);
            }else if(soDo < 10000){
                soTrungThuong = "0" + String.valueOf(soDo);
            }else if(soDo >= 10000){
                soTrungThuong = String.valueOf(soDo);
            }
            if(prize.trim().equals(soTrungThuong.trim())){
                return true;
            }
        }
        return false;
    }

    public Boolean checkFifthPrize(TicketModel ticket){
        //ResultKQXSService resultKQXSService = new ResultKQXSService(ticket);
        String fifthPrize = resultKQXSService.getFifthPrize();
        int soDo = Integer.parseInt(ticket.getSoTrungThuong().trim()) % 10000;
        String soTrungThuong = String.valueOf(soDo);
        if(soDo < 10){
            soTrungThuong = "000" + String.valueOf(soDo);
        }else if(soDo < 100){
            soTrungThuong = "00" + String.valueOf(soDo);
        }else if(soDo < 1000){
            soTrungThuong = "0" + String.valueOf(soDo);
        }else if(soDo >= 1000){
            soTrungThuong = String.valueOf(soDo);
        }
        if(fifthPrize.trim().equals(soTrungThuong.trim())){
            return true;
        }
        return false;
    }

    public Boolean checkSixthPrize(TicketModel ticket){
        //ResultKQXSService resultKQXSService = new ResultKQXSService(ticket);
        String sixthPrize = resultKQXSService.getSixthPrize();
        String[] sixthPrizeArr = sixthPrize.split("-");
        for(String prize: sixthPrizeArr){
            int soDo = Integer.parseInt(ticket.getSoTrungThuong().trim()) % 10000;
            String soTrungThuong = String.valueOf(soDo);
            if(soDo < 10){
                soTrungThuong = "000" + String.valueOf(soDo);
            }else if(soDo < 100){
                soTrungThuong = "00" + String.valueOf(soDo);
            }else if(soDo < 1000){
                soTrungThuong = "0" + String.valueOf(soDo);
            }else if(soDo >= 1000){
                soTrungThuong = String.valueOf(soDo);
            }
            if(prize.trim().equals(soTrungThuong.trim())){
                return true;
            }
        }
        return false;
    }

    public Boolean checkSeventhPrize(TicketModel ticket){
        //ResultKQXSService resultKQXSService = new ResultKQXSService(ticket);
        String seventhPrize = resultKQXSService.getSeventhPrize();
        int soDo = Integer.parseInt(ticket.getSoTrungThuong().trim()) % 1000;
        String soTrungThuong = String.valueOf(soDo);
        if(soDo < 10){
            soTrungThuong = "00" + String.valueOf(soDo);
        }else if(soDo < 100){
            soTrungThuong = "0" + String.valueOf(soDo);
        }else if(soDo >= 100){
            soTrungThuong = String.valueOf(soDo);
        }
        if(seventhPrize.equals(soTrungThuong.trim())){
            return true;
        }
        return false;
    }
    public Boolean checkEighthPrize(TicketModel ticket){
        //ResultKQXSService resultKQXSService = new ResultKQXSService(ticket);
        int soDo = Integer.parseInt(ticket.getSoTrungThuong().trim()) % 100;
        String soTrungThuong = String.valueOf(soDo);
        if(soDo < 10){
            soTrungThuong = "0" + String.valueOf(soDo);
        }else if(soDo >= 1000){
            soTrungThuong = String.valueOf(soDo);
        }
        String eighthPrize = resultKQXSService.getEighthPrize();
        if(eighthPrize.trim().equals(soTrungThuong.trim())){
            return true;
        }
        return false;
    }
}
