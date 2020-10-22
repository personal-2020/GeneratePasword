package GeneratorPassword.GeneratorPassword;

import GeneratorPassword.GeneratorPassword.services.PaswordGeneratorServices;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorPasswordApplication_PaswordGenerator_Services_Tests {

    
    @Autowired
    private PaswordGeneratorServices pd;
    
    
    @Test
    public void contextLoads() {
        assertThat(pd).isNotNull();
    }

    
    @Test
    public void CreateInstancePasswordGenerateNewMatriz(){
        pd.generateNewMatriz();
        assertThat(pd.getMatrizz()).isNotNull();
    }
    
    
    @Test
    public void TestVisitados(){
        //assertThat(pd.getVisitados()).;
    
    }
    

    @Test
    public void ll(){
    
    }
    
    @Test
    public void lll(){
    
    }
    
    
}
