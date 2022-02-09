package com.cursosandroidant.inventory.addModule.view

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.safe.args.generator.NullValue
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosandroidant.inventory.R
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
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

    @Test//Todo- Cuando el usuario le aparesca el Dialog y le de cancelar este desaparesca y se vuelva null
    fun cancelDialog_isNullTest(){
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_Inventory)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment { fragment ->
            (fragment.dialog as? AlertDialog)?.let {//TODO- En caso de que no sea Null
                it.getButton(DialogInterface.BUTTON_NEGATIVE).performClick()//TODO- (performClick) que se ejecute el evento onlick en este boton
                assertThat(fragment.dialog,`is`(nullValue()))
            //TODO- al dar click en el boton cancelar, ene efecto se cancela y se destruye nuestro fragmento y queda null
            }
        }
    }
}