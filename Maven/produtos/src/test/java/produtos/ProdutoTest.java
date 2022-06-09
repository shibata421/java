package produtos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.jupiter.api.Test;

class ProdutoTest {

	@Test
	void deveCalcularPrecoComImposto() {
		Produto bala = new Produto("juquinha", 0.1);
		assertThat(bala.getPrecoComImposo(), closeTo(0.11,0.00001));
	}

}
