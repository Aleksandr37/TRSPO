public class ChickenVoice {
    static  EggVoice mAnotherOpinion; //побочный поток
    public static void main(String[] args) {

        mAnotherOpinion = new EggVoice(); //создание потока
        System.out.println("Спор начат ...");
        mAnotherOpinion.start(); //запуск потока

        for (int i = 0; i < 5; i ++)
        {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}

            System.out.println("Курица!");
        }

        if (mAnotherOpinion.isAlive()) //если апонент еще не сказал последнее слово
        {
            try {
                mAnotherOpinion.join(); //подождать пока опонент закончит высказывание
            }catch (InterruptedException e) {}

            System.out.println("Первым появилось яйцо!");
        }
        else  // если апонент уже закончил высказываться
        {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор окончен!");
    }
}
