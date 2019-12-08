package com.dsi32gr11.tunisiaup.ui.north;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dsi32gr11.tunisiaup.R;

import java.util.ArrayList;
import java.util.HashMap;

public class NorthFragment extends Fragment {
    private NorthViewModel northViewModel;
    protected ListView maListViewPerso;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        northViewModel =
                ViewModelProviders.of(this).get(NorthViewModel.class);
        View root = inflater.inflate(R.layout.fragment_north, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        northViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
         maListViewPerso = root.findViewById(R.id.li);

        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String, String> map;

        // Création d'une "HashMap" pour insérer les informations du premier item de notre "ListView"
        map = new HashMap<>();
        // On insère un élément "titre" que l'on récupérera dans le "TextView titre" créé dans le fichier affichage_item.xml
        map.put("titre", "Bizert");
        // On insère un élément "description" que l'on récupérera dans le "TextView description" créé dans le fichier affichage_item.xml
        map.put("description", "Bizerte est une ville du nord de la Tunisie située entre la mer Méditerranée et le lac de Bizerte. Elle est le chef-lieu d'un gouvernorat peuplé de plus d'un demi-million d'habitants. La ville compte 136 917 habitants en 2014.");
        // On insère la "référence" à l'image (convertit en String car normalement c'est un int) que l'on récupérera dans le "ImageView" créé dans le fichier affichage_item.xml
        map.put("img", String.valueOf(R.drawable.bizerte));
        // Enfin on ajoute cette "HashMap" dans la "ArrayList"
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Tabarka");
        map.put("description", "Tabarka est une agréable ville côtière, avec une longue promenade le long de la mer et du port. C'est le centre tunisien de la plongée sous-marine et une destination balnéaire fréquentée. L'affluence touristique a beaucoup diminué depuis la Révolution de Jasmin, en 2010.");
        map.put("img", String.valueOf(R.drawable.tabarka));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Douga");
        map.put("description", "Dougga est un site archéologique situé dans la délégation de Téboursouk au Nord-Ouest de la Tunisie.\n" +
                "\n" +
                "L'Unesco a classé ce site sur la liste du patrimoine mondial en 1997, considérant qu'il s'agit de la « petite ville romaine la mieux conservée de l'Afrique du Nord ». La cité, qui se trouve en pleine campagne, est bien protégée de l'urbanisme moderne, contrairement, par exemple, à Carthage pillée et reconstruite à de nombreuses reprises.");
        map.put("img", String.valueOf(R.drawable.dougga));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "El Kef");
        map.put("description", "Le Kef est une ville du Nord-Ouest de la Tunisie et le chef-lieu du gouvernorat du même nom.\n" +
                "\n" +
                "Située au nord-ouest du pays, à 175 kilomètres à l'ouest de Tunis et à une quarantaine de kilomètres à l'est de la frontière tuniso-algérienne, elle compte 54 690 habitants en 2014");
        map.put("img", String.valueOf(R.drawable.kef));
        listItem.add(map);

        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                listItem,
                R.layout.activity_main_item,
                new String[]{"img", "titre", "description"},
                new int[]{R.id.icon, R.id.titre, R.id.description});

        // On attribue à notre "ListView" l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(adapter);
        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Méthode 1
                HashMap map = (HashMap) maListViewPerso.getItemAtPosition(position);
                Toast.makeText(getActivity(), (String) map.get("titre"),
                        Toast.LENGTH_SHORT).show();

            }
        });
        maListViewPerso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // On récupère la "HashMap" contenant les infos de notre item (titre, description, img)
                HashMap map = (HashMap) maListViewPerso.getItemAtPosition(position);
                // On crée une boite de dialogue
                AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
                // On attribue un titre à notre boite de dialogue
                adb.setTitle("Sélection Item");
                // On insère un message à notre boite de d4ialogue, et ici on affiche le titre de l'item cliqué
                adb.setMessage("Votre choix : " + map.get("titre"));
                // On indique que l'on veut le bouton "ok" à notre boite de dialogue
                adb.setPositiveButton("Ok", null);
                // On affiche la boite de dialogue
                adb.show();
                return true;
            }
        });
        return root;
    }
}