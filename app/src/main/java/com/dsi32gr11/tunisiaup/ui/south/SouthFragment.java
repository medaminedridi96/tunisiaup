package com.dsi32gr11.tunisiaup.ui.south;

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

public class SouthFragment extends Fragment {

    private SouthViewModel southViewModel;
    protected ListView maListViewPerso;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        southViewModel =
                ViewModelProviders.of(this).get(SouthViewModel.class);
        View root = inflater.inflate(R.layout.fragment_south, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        southViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        maListViewPerso = root.findViewById(R.id.li2);

        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String, String> map;

        // Création d'une "HashMap" pour insérer les informations du premier item de notre "ListView"
        map = new HashMap<>();
        // On insère un élément "titre" que l'on récupérera dans le "TextView titre" créé dans le fichier affichage_item.xml
        map.put("titre", "Djerba");
        // On insère un élément "description" que l'on récupérera dans le "TextView description" créé dans le fichier affichage_item.xml
        map.put("description", "est une île de la mer Méditerranée d'une superficie de 514 km2 (25 kilomètres sur 20 et un littoral de 150 kilomètres) et située à l'est de la côte orientale tunisienne. Plus grande île des côtes d'Afrique du Nord, localisée au sud-est du golfe de Gabès qu'elle borde par ses côtes orientale et septentrionale2, Djerba ferme au sud le golfe de Boughrara. Sa principale ville, Houmt Souk, rassemble à elle seule 42 992 des 163 726 Djerbiens");
        // On insère la "référence" à l'image (convertit en String car normalement c'est un int) que l'on récupérera dans le "ImageView" créé dans le fichier affichage_item.xml
        map.put("img", String.valueOf(R.drawable.djerba));
        // Enfin on ajoute cette "HashMap" dans la "ArrayList"
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Tozeur");
        map.put("description", "Tozeur est une ville du Jérid tunisien et le chef-lieu du gouvernorat du même nom. Elle compte 37 365 habitants selon le recensement de 20142.\n" +
                "\n" +
                "Située au nord-ouest du Chott el-Jérid, elle se trouve à 450 kilomètres au sud-ouest de Tunis. Il s'agit de l'une des oasis du désert du Sahara. Tozeur est une ville avec un passé religieux important et connue pour ses lettrés comme sa topographie contemporaine, parsemée de marabouts, en témoigne.");
        map.put("img", String.valueOf(R.drawable.tozeur));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Gabes");
        map.put("description", "Gabes est une ville du sud-est de la Tunisie, comptant 130 984 habitants en 20141 et le chef-lieu du gouvernorat du même nom.");
        map.put("img", String.valueOf(R.drawable.gabes));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Matmata");
        map.put("description", "Matmata est un village du sud de la Tunisie dépendant du gouvernorat de Gabès.\n" +
                "\n" +
                "Même si la Nouvelle Matmata est devenue la principale localité de la région, le centre de la tribu des Matmata reste l'ancien village situé au cœur des montagnes. Le développement urbain et l'exode rural des populations a vidé et désertifié celui-ci au profit de la nouvelle ville moderne. ");
        map.put("img", String.valueOf(R.drawable.matmata));
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