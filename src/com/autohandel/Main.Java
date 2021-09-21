package com.autohandel;

//        OK	przeglądaj bazę samochodów do kupienia
//        OK	kup samochód
//        OK	przeglądaj bazę posiadanych samochodów
//        OK	napraw samochód
//        OK	przejrzyj potencjalnych klientów
//        OK	sprzedaj samochód za określoną cenę potencjalnemu klientowi
//        ●	kup reklamę
//        OK	kup reklamę
//        OK	sprawdź stan konta
//        OK	sprawdź historię transakcji
//        ●	sprawdź historię napraw każdego pojazdu
//        ●	sprawdź sumę kosztów napraw i mycia dla każdego z posiadanych pojazdów

//        OK	sprawdź historię napraw każdego pojazdu
//        OK	sprawdź sumę kosztów napraw i mycia dla każdego z posiadanych pojazdów
//        OK    Moze wygrać



public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        while (!game.close){
            game.update();
        }
    }
}
