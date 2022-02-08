package com.cursosandroidant.inventory.addModule.view

import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosandroidant.inventory.R
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AddProductFragmentTest{
    @Test
    fun createDialog_notNullTest(){
        //TODO-Creamos el escenario del fragmento (AddProductFragment) y le pasamos el thema
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_Inventory)
        //TODO- Configuramos el ciclo de vidad en que se encuentra el Fragmento
        scenario.moveToState(Lifecycle.State.RESUMED)//escenario en que nuestro Dialog este visible
        //TODO- Accedemos a el.
        scenario.onFragment{ fragment ->
            assertThat(fragment.dialog, `is`(notNullValue()))//TODO- Compruebe que no es Null
        }
    }
}