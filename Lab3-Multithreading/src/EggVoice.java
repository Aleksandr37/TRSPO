public class EggVoice extends Thread {
    @Override
    public void  run()
    {
        for (int i = 0; i < 5; i++)
        {
            try {
                sleep(1000); // приостанавливает поток на 1 секунду
            }catch (InterruptedException e){}
            System.out.println("Яйцо!");
        }
        // слово яйцо сказано 5 раз
    }
}
