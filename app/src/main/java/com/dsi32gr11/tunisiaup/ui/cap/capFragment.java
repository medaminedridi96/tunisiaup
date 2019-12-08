package com.dsi32gr11.tunisiaup.ui.cap;

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

public class capFragment extends Fragment {

    private capViewModel capViewModel;
    protected ListView maListViewPerso;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        capViewModel =
                ViewModelProviders.of(this).get(capViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cap, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        capViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        maListViewPerso = root.findViewById(R.id.li1);

        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String, String> map;

        // Création d'une "HashMap" pour insérer les informations du premier item de notre "ListView"
        map = new HashMap<>();
        // On insère un élément "titre" que l'on récupérera dans le "TextView titre" créé dans le fichier affichage_item.xml
        map.put("titre", "Nabeul");
        // On insère un élément "description" que l'on récupérera dans le "TextView description" créé dans le fichier affichage_item.xml
        map.put("description", "Nabeul est une ville du nord-est de la Tunisie, située au sud de la péninsule du cap Bon, à une soixantaine de kilomètres au sud-est de Tunis.");
        // On insère la "référence" à l'image (convertit en String car normalement c'est un int) que l'on récupérera dans le "ImageView" créé dans le fichier affichage_item.xml
        map.put("img", String.valueOf(R.drawable.nabeul));
        // Enfin on ajoute cette "HashMap" dans la "ArrayList"
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Kelibia");
        map.put("description", "Kélibia appelée Aspis lors de la Première guerre punique, est une ville côtière du Nord-Est de la Tunisie. Située à la pointe de la péninsule du cap Bon, à une centaine de kilomètres de Tunis via Menzel Bouzelfa, elle est la troisième ville du gouvernorat de Nabeul après Nabeul et Hammamet.");
        map.put("img", String.valueOf(R.drawable.kelibia));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Hammamet");
        map.put("description", "Hammamet est une ville tunisienne située au nord-est, sur la côte sud-est du cap Bon, à une soixantaine de kilomètres au sud de Tunis.");
        map.put("img", String.valueOf(R.drawable.hammamet));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Haouaria");
        map.put("description", "El Haouaria est une ville tunisienne située à l'extrémité nord-est du cap Bon, à l'entrée du golfe de Tunis.\n" +
                "\n" +
                "Rattachée administrativement au gouvernorat de Nabeul, elle est le centre d'une délégation et constitue une municipalité comptant 9 508 habitants en 20142. La municipalité est créée par le décret du 2 avril 19663. Elle se situe à 120 kilomètres de Tunis et à 80 kilomètres de la Sicile");
        map.put("img", String.valueOf(R.drawable.haouaria));
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