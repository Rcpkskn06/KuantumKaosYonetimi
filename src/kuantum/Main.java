package kuantum;
import java.util.*;
public class Main {

	public static void main(String[] args) throws KuantumCokusuException {
		List<KuantumNesnesi> envanter = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		
		while(true)
		{
			try
			{
				System.out.println("\nKUANTUM AMBARI KONTROL PANELİ");
                System.out.println("1) Yeni Nesne Ekle");
                System.out.println("2) Envanteri Listele");
                System.out.println("3) Nesneyi Analiz Et");
                System.out.println("4) Acil Durum Soğutması");
                System.out.println("5) Çıkış");
                System.out.print("Seçiminiz: ");

                String secim = sc.nextLine();

                switch (secim) {
                    case "1":
                        int r = rnd.nextInt(3);
                        String id = UUID.randomUUID().toString().substring(0, 6);
                        KuantumNesnesi nesne = (r == 0) ? new VeriPaketi(id)
                                : (r == 1) ? new KaranlikMadde(id)
                                : new AntiMadde(id);
                        envanter.add(nesne);
                        System.out.println("Nesne oluşturuldu: " + id);
                        break;

                    case "2":
                        for (KuantumNesnesi n : envanter)
                            System.out.println(n.durumBilgisi());
                        break;

                    case "3":
                    	System.out.print("ID: ");
                        String idA = sc.nextLine();
                        var n1 = envanter.stream().filter(x -> x.getId().equals(idA)).findFirst().orElse(null);

                        if (n1 == null) { System.out.println("Nesne yok."); break; }

                        n1.analizEt();
                        System.out.println("Yeni stabilite: " + n1.getStabilite());
                        if (n1.getStabilite() <= 0)
                            throw new KuantumCokusuException(n1.getId());
                        break;

                    case "4":
                    	System.out.print("ID: ");
                        String idB = sc.nextLine();
                        var n2 = envanter.stream().filter(x -> x.getId().equals(idB)).findFirst().orElse(null);

                        if (n2 == null) { System.out.println("Nesne yok."); break; }

                        if (n2 instanceof IKritik kritik) {
                            kritik.acilDurumSogutmasi();
                            System.out.println("Soğutma uygulandı. Yeni stabilite: " + n2.getStabilite());
                        } else {
                            System.out.println("Bu nesne soğutulamaz!");
                        }
                        break;

                    case "5":
                        return;
			}
		}catch(RuntimeException e)
			{
			     if(e.getCause() instanceof KuantumCokusuException)
			     {
			    	 System.out.println("\\n*** SİSTEM ÇÖKTÜ! TAHLİYE BAŞLATILIYOR... ***");
			    	 System.out.println(e.getCause().getMessage());
			    	 return;
			     }
			}
	}

 }
	
}
